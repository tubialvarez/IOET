package service;

import java.util.*;
import data.Data;

public class Util {

    public static ArrayList encuentros = new ArrayList();

    public ArrayList Ejecutar(){
        Data datas = new Data();
        ArrayList datos = new ArrayList();
        datos = datas.texto();
        Nombres(datos);
        return datos;
    }
    
    public ArrayList<String> Nombres(ArrayList<String> data){
        ArrayList<String> trabajadores = new ArrayList();
        ArrayList<String> horariosgeneral = new ArrayList();
        String auxiliar = "";
        for(Integer i = 0; i<=data.size()-1; i++){
            Integer k = 0;
            auxiliar = data.get(i).toString();
            for(Integer j = 0; j<=auxiliar.length(); j++){
                String aux = auxiliar.substring(j, j+1);
                if(aux.equals("=")){
                    j = auxiliar.length()+1;
                }
                k++;
            }
            trabajadores.add(auxiliar.substring(0, k-1));
            horariosgeneral.add(auxiliar.substring(k));
        }
        ArrayList<String> Emparejados = Mezcla(trabajadores);
        ArrayList<String> dia1 = lun_sab(horariosgeneral, trabajadores, "MO");
        dia1 = lun_sab(dia1, trabajadores, "TU");
        dia1 = lun_sab(dia1, trabajadores, "WE");
        dia1 = lun_sab(dia1, trabajadores, "TH");
        dia1 = lun_sab(dia1, trabajadores, "FR");
        dia1 = lun_sab(dia1, trabajadores, "SA");
        dia1 = lun_sab(dia1, trabajadores, "SU");

        output(Emparejados);
        return Emparejados;

    }

    public ArrayList<String> lun_sab(ArrayList<String> horarios, ArrayList<String> empleados, String dia){
        ArrayList<String> lunes = new ArrayList();
        ArrayList<String> resultante = new ArrayList();
        ArrayList<String> entrada = new ArrayList();
        ArrayList<String> salida = new ArrayList();
        String auxiliar = "";
        for(Integer i = 0; i<=horarios.size()-1; i++){
            Integer k = 0;
            auxiliar = horarios.get(i).toString();
            if(auxiliar != "" && auxiliar.substring(0, 2).equals(dia)){
                for(Integer j = 0; j<=auxiliar.length()-1;j++){
                    if (auxiliar.substring(j, j+1).equals(",")){
                        j = auxiliar.length()+1;
                    }
                    k++;
                }
                lunes.add(auxiliar.substring(2, k-1));
            }else {
                lunes.add("null");
            }
            resultante.add(auxiliar.substring(k));
        }
        for(Integer i = 0; i<=lunes.size()-1; i++){
            Integer k = 0;
            auxiliar = lunes.get(i).toString();
            if(auxiliar == "null"){
                entrada.add("00:00");
                salida.add("00:00");
                String aux1 = entrada.get(i).toString();
                String resultado = conversion(aux1);
                entrada.set(i, resultado);
                aux1 = salida.get(i).toString();
                resultado = conversion(aux1);
                salida.set(i, resultado);
            }else {
                for(Integer j = 0; j<=auxiliar.length()-1; j++){
                    if(auxiliar.substring(j, j+1).equals("-")){
                        j = auxiliar.length()+1;
                    }
                    k++;
                }
                entrada.add(auxiliar.substring(0, k-1));
                salida.add(auxiliar.substring(k));
                String aux1 = entrada.get(i).toString();
                String resultado = conversion(aux1);
                entrada.set(i, resultado);
                aux1 = salida.get(i).toString();
                resultado = conversion(aux1);
                salida.set(i, resultado);
            }
        }

        
        encuentros = calculo(entrada, salida);
        return resultante;
    }

    public ArrayList<String> Mezcla(ArrayList<String> nombres){
        ArrayList<String> mezclados = new ArrayList();
        for (Integer i = 0; i<= nombres.size()-1; i++){
            for (Integer j = nombres.size()-1; j>=i+1; j--){
                mezclados.add(""+nombres.get(i)+" y "+nombres.get(j)+"");
                encuentros.add("0");
            }
        }
        return mezclados;
    }

    public String conversion (String horario){
        String[] hm = horario.split(":");
        Integer h = Integer.parseInt(hm[0]);
        Integer m = Integer.parseInt(hm[1]);
        Integer hm100 = (h*100)+m;
        String aux = ""+hm100+"";
        return aux;
    }

    public ArrayList<String> calculo(ArrayList<String> entrada, ArrayList<String> salida){
        String ce1, cs1, ce2, cs2;
        Integer e1, s1, e2, s2;
        Integer auxiliar=0;
        for (Integer i = 0; i<= entrada.size()-1; i++){
            for (Integer j = entrada.size()-1; j>=i+1; j--){
                ce1 = entrada.get(i).toString();
                cs1 = salida.get(i).toString();
                ce2 = entrada.get(j).toString();
                cs2 = salida.get(j).toString();
                e1 = Integer.parseInt(ce1);
                s1 = Integer.parseInt(cs1);
                e2 = Integer.parseInt(ce2);
                s2 = Integer.parseInt(cs2);
                if(!(e1 == 0 && s1 == 0) || !(e2 == 0 && s2 == 0)){
                    if ((e1<=e2 && e2<=s1)||(e1<=s2 && s2<=s1)||(e2<=e1 && e1<=s2)||(e2<=s1 && s1<=s2)){
                         encuentros.set(auxiliar, Integer.parseInt(encuentros.get(auxiliar).toString())+1);
                    }
                }
                auxiliar++;
            }
        }

        return encuentros;
    }

    public void output(ArrayList personal_combinado){
        Map<Integer, String> resultado = new HashMap();
        for(Integer i=0; i<=personal_combinado.size()-1; i++){
            if(Integer.parseInt(encuentros.get(i).toString()) == 1){
                resultado.put(i, personal_combinado.get(i).toString()+" coincidieron " +encuentros.get(i)+" vez a la semana");
            }else{
                resultado.put(i, personal_combinado.get(i).toString()+" coincidieron " +encuentros.get(i)+" veces a la semana");
            }
        }
        for(Integer i = 0; i<resultado.size(); i++){
            System.out.println(resultado.get(i));
        }
    }
}
