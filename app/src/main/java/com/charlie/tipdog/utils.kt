package com.charlie.tipdog

import java.lang.Exception

class utils {

}
fun calculate(input : String, rate:String) : String {
  return try {
    val x = input.toFloat()
    val y = x * rate.toFloat();
    String.format("%.2f", y)
  } catch (e : Exception){
    ""
  }
}