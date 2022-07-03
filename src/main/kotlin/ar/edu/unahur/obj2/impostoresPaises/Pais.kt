package ar.edu.unahur.obj2.impostoresPaises

class Pais(val nombre:String,val codigoIso3:String,var poblacion:Int,val superficie:Int,
           val codigoDeMoneda:String,var cotizacionDolar:Double,val continente:String)
          {
  var paisesLimitrofes= mutableListOf<Pais>()
  var bloquesRegionales= mutableListOf<String>()
  var idiomasOficiales= mutableListOf<String>()
  fun ingresoDePaisConQueLimita(pais:Pais){
    paisesLimitrofes.add(pais)
  }
  fun ingresoDeBloqueRegional(bloque: String){
    bloquesRegionales.add(bloque)
  }
  fun ingresoDeidioma(idioma: String){
    idiomasOficiales.add(idioma)
  }
  fun esPlurnacional()= idiomasOficiales.count() >1
  fun esIsla()=paisesLimitrofes.count() == 0
  fun densidadPoblacional()= (poblacion/superficie).toInt()
  fun vecinoMasPoblado(): Pais {
    var masPoblado=this
    if (!esIsla()){
      for (pais in paisesLimitrofes ){
        if(pais.poblacion>masPoblado.poblacion){
          masPoblado=pais
        }
      }
    }
    else{
      println("Es una Isla!")
    }
    return masPoblado
  }
}
