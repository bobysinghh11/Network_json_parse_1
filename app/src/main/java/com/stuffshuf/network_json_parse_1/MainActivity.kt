package com.stuffshuf.network_json_parse_1

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnData.setOnClickListener {

            val newtworkConnection=NetworkConnection()
            newtworkConnection.execute("https://jsonplaceholder.typicode.com/users")
        }



    }

    inner class NetworkConnection:AsyncTask<String, Int, String>() {


        override fun doInBackground(vararg Url: String?): String {

            val googleUrl=URL(Url[0])
            val connection= googleUrl.openConnection() as HttpURLConnection
            val isr=InputStreamReader(connection.inputStream)
            val bufferReader=BufferedReader(isr)
            var sb=StringBuilder()
            var buffer:String?=""
            while (buffer!=null)
            {
                sb.append(buffer)
                buffer=bufferReader.readLine()

            }
            return sb.toString()

        }

        override fun onPostExecute(result: String?) {

            val userList= arrayListOf<Users>()
            val data=Gson().fromJson(result, Array<Users>::class.java)
            userList.addAll(data)


            showdata.layoutManager=GridLayoutManager(
                this@MainActivity,
                1,
                GridLayoutManager.VERTICAL,
                false
            )
            showdata.adapter=UsersAdapter(userList)
        }


    }
}
