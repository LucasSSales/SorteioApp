package lucasssales.com.sorteio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validar(entrada:String) : Boolean{
        if(entrada.isBlank() || entrada.isEmpty()){
            return false;
        }
        return true;
    }

    fun validarIntervalo(inicio:Int, fim:Int) : Boolean{
        if(inicio >= fim ){
            return false
        }
        return true
    }


    fun sortearNumero(view:View){

        val qntdd = qntdd.text.toString()
        val inicio = inicio.text.toString()
        val fim = fim.text.toString()

        var texto = findViewById(R.id.sorteado) as TextView

        var num = Random().nextInt(11)

        if(validar(qntdd) && validar(inicio) && validar(fim)){
            var i = inicio.toInt()
            var f = fim.toInt()

            if(validarIntervalo(i, f)){
                var saida = "";
                //texto.setText("$num")
                for(n in 1..qntdd.toInt()){
                    saida += ""+Random().nextInt(f-i+1) + i + ", "
                }
                texto.setText(saida)
            }else{
                texto.setText("Insira um intervalo válido!")
            }

        }else{
            texto.setText("Preencha os Campos!")
        }





    }
}
