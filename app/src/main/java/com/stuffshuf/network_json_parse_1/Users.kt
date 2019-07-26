package com.stuffshuf.network_json_parse_1


data class Address(
    val street:String,
    val city:String,
    val suite:String

)


/*class Users {

    val id: Int?=null
    val name: String?=null
    val username: String?=null
    val email: String?=null
    val address:Address?=null
    val phone:String?=null
    val website:String?=null
    val company:Company?=null

  //  val phone:String?=null
  //  val website:String?=null

  //   val city:Address?=null
   //  val street:Address?=null
  //  val suite:Address?=null
}
*/

data class Users(
    val id:Int,
    val name:String,
    val username:String,
    val email:String,
    val address: Address
)