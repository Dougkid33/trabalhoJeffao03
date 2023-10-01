package com.example.trabalhojeffao03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var inserirMatriz : EditText
    lateinit var inserirMatrizButton : Button
    private var Matriz= ArrayList<String>()
    lateinit var mostrarMatriz : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inserirMatriz = findViewById(R.id.inserirMatriz)
        inserirMatrizButton = findViewById(R.id.inserirButton)
        mostrarMatriz = findViewById(R.id.amostraMatriz)

        // Adiciona um evento de clique ao botão `inserirMatrizButton`
        inserirMatrizButton.setOnClickListener {
            // Lê o valor de X do campo de texto `inserirMatriz`
            val X = inserirMatriz.text.toString()

            // Adiciona o valor X à matriz
            Matriz.add(X)

            // Atualiza o TextView para mostrar a matriz atualizada
            mostrarMatriz.text = Matriz.toString()

            // Limpa o campo de inserção
            inserirMatriz.setText("")

            // Verifica se o valor X existe na matriz
            val existe = verificarMatriz(X.toInt())

            // Imprime uma mensagem na tela, indicando se o valor X existe ou não na matriz
            if (existe) {
                Toast.makeText(this, "O valor X existe na matriz.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "O valor X não existe na matriz.", Toast.LENGTH_SHORT).show()
            }
        }

        // Remove os elementos duplicados da matriz quando o campo de texto `inserirMatriz` perde o foco
        inserirMatriz.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                Matriz = ArrayList(Matriz.distinct())
            }
        }
    }

    fun verificarMatriz(X: Int): Boolean {
        // Verifica se o valor X existe na matriz
        for (elemento in Matriz) {
            if (elemento.toInt() == X) {
                return true
            }
        }
        return false
    }
}