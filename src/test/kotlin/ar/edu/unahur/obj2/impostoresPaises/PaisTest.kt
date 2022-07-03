package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class PaisTest:DescribeSpec( {
  describe("completando paises"){
    val argentina=Pais("Argentina","ARG",55590857,2780000,"ARS",215.2,"America")
    val chile=Pais("Chile","CHL",25590857,780000,"CHS",200.2,"America")
    val paraguay=Pais("Paraguay","PAR",7453695,406752,"PSA",980.5,"America")
    val brasil=Pais("Brasil","BRA",99090857,30080000,"BRS",24.5,"America")
    val ecuador=Pais("Ecuador","ECU",28590857,5280000,"ECU",5348.0,"America")
    val uruguay=Pais("Uruguay","URU",8590857,1280000,"URS",465.0,"America")
    val cuba=Pais("Cuba","CUB",190857,80000,"CUS",1465.0,"America")
    argentina.ingresoDeBloqueRegional("UNASUR")
    paraguay.ingresoDeBloqueRegional("UNASUR")
    brasil.ingresoDeBloqueRegional("UNASUR")
    chile.ingresoDeBloqueRegional("PACIFICO SUR")
    ecuador.ingresoDeBloqueRegional("PACIFICO SUR")


    argentina.ingresoDePaisConQueLimita(brasil)
    argentina.ingresoDePaisConQueLimita(paraguay)
    argentina.ingresoDePaisConQueLimita(chile)
    argentina.ingresoDePaisConQueLimita(uruguay)
    argentina.ingresoDeidioma("español")
    argentina.ingresoDeidioma("ingles")

    brasil.ingresoDePaisConQueLimita(paraguay)
    brasil.ingresoDePaisConQueLimita(argentina)
    brasil.ingresoDePaisConQueLimita(uruguay)
    brasil.ingresoDeidioma("portuguez")
    brasil.ingresoDeidioma("ingles")

    cuba.ingresoDeidioma("español")


    uruguay.ingresoDePaisConQueLimita(argentina)
    uruguay.ingresoDePaisConQueLimita(brasil)
    uruguay.ingresoDePaisConQueLimita(paraguay)
    uruguay.ingresoDeidioma("español")

    chile.ingresoDePaisConQueLimita(paraguay)
    chile.ingresoDePaisConQueLimita(argentina)
    chile.ingresoDeidioma("español")

    paraguay.ingresoDePaisConQueLimita(brasil)
    paraguay.ingresoDePaisConQueLimita(argentina)
    paraguay.ingresoDeidioma("guarani")


    it("Indicar si es plurinacional"){
      argentina.esPlurnacional().shouldBeTrue()
      chile.esPlurnacional().shouldBeFalse()
      brasil.esPlurnacional().shouldBeTrue()

    }
    it("Saber si es una isla"){
      chile.esIsla().shouldBeFalse()
      cuba.esIsla().shouldBeTrue()
    }
    it("Calcular su densidad poblacional"){
      paraguay.densidadPoblacional().shouldBe(18)
    }
    it("Conocer al vecino más poblado"){
      argentina.vecinoMasPoblado().shouldBe(brasil)
      chile.vecinoMasPoblado().shouldBe(argentina)

    }

  }
})