package br.pro.adalto.applivraria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class LivrosActivity extends AppCompatActivity {

    private ListView lvLivros;
    private Button btnAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livros);

        lvLivros = findViewById(R.id.lvLivros);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LivrosActivity.this,MainActivity.class);
            }
        });
    }

    private void carregarLivros(){
        List<Livro> lista = LivroDAO.getLivros(this);
        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
        lvLivros.setAdapter(adapter);
    }

    protected void onStart(){
        super.onStart();
        carregarLivros();
    }
}