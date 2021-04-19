package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("Pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada("Papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario){
       // System.out.println( escolhaUsuario );

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);



        int numero = new Random().nextInt(3 );
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "Pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
                (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura")
        ){                //app ganhador
            textoResultado.setText("Você perdeu!  :(");

        }else if(
                (escolhaUsuario == "Tesoura" && escolhaApp == "Papel") ||
                (escolhaUsuario == "Papel" && escolhaApp == "Pedra") ||
                (escolhaUsuario == "Pedra" && escolhaApp == "Tesoura")
        ){             //usuario ganhador
            textoResultado.setText("Você ganhou!  :D");

        }else{                   //Empate
            textoResultado.setText("Empatamos! :|");
        }

        System.out.println("Item clicado: " + escolhaApp);


    }
}