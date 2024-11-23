package com.example.gaterjv.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.gaterjv.Adapter.PopularListAdapter;
import com.example.gaterjv.Domain.PopularDomain;
import com.example.gaterjv.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recyclerViewPupolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initRecyclerview();
    }

    private void initRecyclerview() {
        ArrayList<PopularDomain> items=new ArrayList<>();
        items.add(new PopularDomain("ASUS PRO 13 M2 Chip","COR PRETO, LAN\t10/100/1000\n" +
                "CAPACIDADE DO DISCO\t512GB SISTEMA OPERATIVO\tWINDOWS 11 PROFISSIONAL,\n" +
                "SUPORTE\tPROCESSADOR ATÉ 4.4GHz COM TURBOBOOST,\n" +
                "PROCESSADOR\tINTEL CORE I5, TAMANHO DO ECRÃ\t15.6, WIFI SIM,  USB SIM,\n" +
                "MEMÓRIA RAM 8GB, BLUETOOTH SIM, VELOCIDADE DE PROCESSADOR\t1.3GHz,\n" +
                "WIRELESS 802.11 G/N MEMÓRIA CACHE 12 MB, NÚCLEOS\t10,\n" +
                "MODELO\tEXPERTBOOK, GERAÇÃO DO PROCESSADOR\t12ª","pic1",15,20,500));
        items.add(new PopularDomain("PS-5 Digital","COR PRETO, LAN\t10/100/1000\n" +
                "CAPACIDADE DO DISCO\t512GB SISTEMA OPERATIVO\tWINDOWS 11 PROFISSIONAL,\n" +
                "SUPORTE\tPROCESSADOR ATÉ 4.4GHz COM TURBOBOOST,\n" +
                "PROCESSADOR\tINTEL CORE I5, TAMANHO DO ECRÃ\t15.6, WIFI SIM,  USB SIM,\n" +
                "MEMÓRIA RAM 8GB, BLUETOOTH SIM, VELOCIDADE DE PROCESSADOR\t1.3GHz,\n" +
                "WIRELESS 802.11 G/N MEMÓRIA CACHE 12 MB, NÚCLEOS\t10,\n" +
                "MODELO\tEXPERTBOOK, GERAÇÃO DO PROCESSADOR\t12ª","pic2",10,4.5,450));
        items.add(new PopularDomain("Iphone 14","COR PRETO, LAN\t10/100/1000\n" +
                "CAPACIDADE DO DISCO\t512GB SISTEMA OPERATIVO\tWINDOWS 11 PROFISSIONAL,\n" +
                "SUPORTE\tPROCESSADOR ATÉ 4.4GHz COM TURBOBOOST,\n" +
                "PROCESSADOR\tINTEL CORE I5, TAMANHO DO ECRÃ\t15.6, WIFI SIM,  USB SIM,\n" +
                "MEMÓRIA RAM 8GB, BLUETOOTH SIM, VELOCIDADE DE PROCESSADOR\t1.3GHz,\n" +
                "WIRELESS 802.11 G/N MEMÓRIA CACHE 12 MB, NÚCLEOS\t10,\n" +
                "MODELO\tEXPERTBOOK, GERAÇÃO DO PROCESSADOR\t12ª","pic3",13,4.2,800));

        recyclerViewPupolar=findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager( new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        adapterPupolar= new PopularListAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }
}