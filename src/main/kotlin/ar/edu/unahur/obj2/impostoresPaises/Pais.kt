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
  fun sonLimitrofe(pais: Pais)=paisesLimitrofes.contains(pais)
  fun necisitanTraductorDialogar(pais: Pais): Boolean {
    var traductor=true
    for (idioma in idiomasOficiales) {
      if (pais.idiomasOficiales.contains(idioma)) {
        traductor = false
      }
    }
    return traductor
  }
  fun esPotencialAliado(pais: Pais): Boolean {
    var potencialAliado=false
    for (bloque in bloquesRegionales) {
      if (pais.bloquesRegionales.contains(bloque)&&!necisitanTraductorDialogar(pais)) {
        potencialAliado=true
      }
    }
    return potencialAliado
  }
  fun convieneIrDeCompras(pais: Pais)=cotizacionDolar<pais.cotizacionDolar

  fun convertidorDeMoneda(pais: Pais,monto:Double): Double {
    var dolares= monto/cotizacionDolar

    return dolares*pais.cotizacionDolar
  }

}
