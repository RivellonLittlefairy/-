package Lambda
fun a(s:String):Int{
    return s.length;

}
fun main(){
    println(high_function(::a, "msf"))
}
fun high_function(func:(String)->Int,s:String):Int{
    return func(s);
}