package br.com.isaconstance.simuladordefrete.frete

import br.com.isaconstance.simuladordefrete.model.TipoFrete
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class CalculadoraFreteTest {

    private val calculadoraFrete = CalculadoraFrete()
    @Test
    fun `frete economic deve calcular valor pelo peso e distancia`(){
        //ASSERT - preparar
        val peso = 2.0
        val distanciaKm = 100.0

        //ACT - executar
        val resultado = calculadoraFrete.calcular(
            TipoFrete.ECONOMICO,
            peso,
            distanciaKm = distanciaKm
        )

        //ASSERT - verificar
        assertEquals(
            22.0,
            resultado.valor,
            0.01
        )

        assertEquals(
             5,
            resultado.prazoDias
        )
    }

    @Test
    fun `peso zero deve retornar erro`(){
        assertThrows(IllegalArgumentException::class.java){
            calculadoraFrete.calcular(
                TipoFrete.ECONOMICO,
                pesoKg = 0.0,
                distanciaKm = 100.0
            )
        }

    }

}