package com.pavel.burritoasistant;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NotaFragment extends Fragment {
    public NotaFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nota, container, false);
        return view;
    }

    //Creacion de las clases del arbol

    //CLASE NODO, CASI IGUAL A LAS QUE HICIMOS EN LAS PRACTICAS
    public class Nodo {
        private String tarea;
        private Nodo izq;
        private Nodo der;
        public Nodo getDer() {
            return der;
        }
        public void setDer(Nodo der) {
            this.der = der;
        }
        public Nodo() {
            this.izq = null;
            this.der = null;
        }
        public Nodo(String tarea) {
            this.tarea = tarea;
            this.izq = null;
        }
        public String getTarea() {
            return tarea;
        }
        public void setTarea(String tarea) {
            this.tarea = tarea;
        }
        public Nodo getIzq() {
            return izq;
        }
        public void setIzq(Nodo izq) {
            this.izq = izq;
        }
    }

    //Creando Arbol
    public class arbol{
        private Nodo root;
        private String where;

        //Nuestro arbol guardará todas las tareas que la empresa necesite para cumplir ciertos objetivos

        //Cada tarea tendrá como mucho otras dos tareas de las que dependa para
        //poder desbloquearse (limitaciones de tiempo/arbol binario)

        //A cada tarea se le podrán realizar acciones: agregar tarea secundaria a la izquierda del arbol
        //agregar tarea secundaria a la derecha del arbol, y por ultimo, eliminar la tarea para
        //darla por concluida o realizada en la empresa.
        public arbol(){
            root = null;
            where = null;
        }
        //AGREGAR NODO EN LA RAIZ CUANDO NO EXISTE NINGUNA TAREA AUN
        public void addRoot(Nodo nuevo){
            root = nuevo;
        }
        //AGREGAR TAREA SECUNDARIA A LA IZQUIERDA EN EL NODO QUE SE HAYA SELECCIONADO PREVIAMENTE
        public void addIzq(Nodo toReem, Nodo nuevo){
            toReem.setIzq(nuevo);
            where = "Izquierda";
        }

        public void addDer(Nodo toReem, Nodo nuevo){
            toReem.setDer(nuevo);
            where = "Derecha";
        }

        private void cuadroSust(){                //agregar context "MainActivity.this" en vez de getActivity
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Sobreescribir?");
            builder.setMessage("Quieres sobreescribir la tarea que se encuentra en la " + where + "?")
                    .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    })
                    .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();

        }

    }


}

