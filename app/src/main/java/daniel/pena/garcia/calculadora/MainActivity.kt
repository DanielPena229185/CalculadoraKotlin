package daniel.pena.garcia.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var oper: Int = 0;
    var numero1: Double = 0.0;
    lateinit var tv_num2: TextView;
    lateinit var tv_num1: TextView;
    var isRealizoOperacionAnterior: Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1);
        tv_num2 = findViewById(R.id.tv_num2);

        val btnBorrar: Button = findViewById(R.id.btn_clear);
        val btnIgual: Button = findViewById(R.id.btn_igual);

        btnIgual.setOnClickListener{
            var numero2: Double = tv_num2.text.toString().toDouble();
            var resp: Double = 0.0;

            when(oper){
                1 -> {
                    resp = numero1 + numero2;
                }
                2 -> {
                    resp = numero1 - numero2;
                }
                3 -> {
                    resp = numero1 * numero2;
                }
                4 -> {
                    resp = numero1 / numero2;
                }
            }
            tv_num2.setText(resp.toString());
            tv_num1.setText("");
            isRealizoOperacionAnterior = true;
        }

        btnBorrar.setOnClickListener{
            tv_num2.setText("");
            tv_num1.setText("");
            numero1 = 0.0;
            oper = 0;
        }

    }

    fun presionarDigito(view :View){

        if(isRealizoOperacionAnterior){
            isRealizoOperacionAnterior = false;
            tv_num2.setText("");
        }
        var num2: String = tv_num2.text.toString();

        when(view.id){
            R.id.btn_0 -> tv_num2.setText(num2 + "0");
            R.id.btn_1 -> tv_num2.setText(num2 + "1");
            R.id.btn_2 -> tv_num2.setText(num2 + "2");
            R.id.btn_3 -> tv_num2.setText(num2 + "3");
            R.id.btn_4 -> tv_num2.setText(num2 + "4");
            R.id.btn_5 -> tv_num2.setText(num2 + "5");
            R.id.btn_6 -> tv_num2.setText(num2 + "6");
            R.id.btn_7 -> tv_num2.setText(num2 + "7");
            R.id.btn_8 -> tv_num2.setText(num2 + "8");
            R.id.btn_9 -> tv_num2.setText(num2 + "9");
            R.id.btn_punto -> tv_num2.setText(num2 + ".")
        }
    }

    fun clickOperacion(view: View){
        numero1 = tv_num2.text.toString().toDouble();
        var num2_text: String = tv_num2.text.toString();
        tv_num2.setText("");
        when(view.id){
            R.id.btn_sum -> {
                tv_num1.setText(num2_text + "+");
                oper = 1;
            }
            R.id.btn_rest -> {
                tv_num1.setText(num2_text + "-");
                oper = 2;
            }
            R.id.btn_multi -> {
                tv_num1.setText(num2_text + "*");
                oper = 3;
            }
            R.id.btn_div -> {
                tv_num1.setText(num2_text + "/");
                oper = 4;
            }
        }
    }
}