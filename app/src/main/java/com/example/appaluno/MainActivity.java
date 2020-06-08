package com.example.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase bd = openOrCreateDatabase("dbAlunosCriar", MODE_PRIVATE, null);

            bd.execSQL("CREATE TABLE IF NOT EXISTS tbPessoas (nome VARCHAR,email VARCHAR, telefone VARCHAR)");

            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Joana','wissam.patron.9m@funbangsan.ga','(81)32102357')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Joquin','jabdofaiq4@grinagclev.ga','(31)23673642')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Carlos','hmustafamahdinsap@fuesculling.tk','(11)21212673')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Paulo','kjuninhosilva1995@speakfimal.tk','(19)64005959')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Renato','qminiamine111s@guayturwork.cf','(63)76115413')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Wilson','2joutam@garantibuyutucu.xyz','(21)94643556')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Claudete','bgobamo@subiri.tk','(15)76326103')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Sophia','4kichi-m1919x@lesabahis23.com','(61)99273568')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Kaique','iomaima.sanixa.3u@torvice.cf','(81)53299490')");
            bd.execSQL("INSERT INTO tbPessoas(nome,email,telefone)VALUES('Thomas','3maro@ringwesttran.ga','(94)86618817')");


            Cursor cursor = bd.rawQuery("SELECT nome, email, telefone FROM tbAlunos", null);

            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");

            cursor.moveToFirst();

            while (cursor != null) {
                Log.i("Resultado - nome", cursor.getString(indiceNome));
                Log.i("Resultado - email", cursor.getString(indiceEmail));
                Log.i("Resultado - telefone", cursor.getString(indiceTelefone));

                cursor.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}