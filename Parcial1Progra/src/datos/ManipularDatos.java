package datos;

import modelo.TablaFactura;

public class ManipularDatos {

    
    /*
    SE CREAN TODAS LAS CONSTANTES QUE SE UTILIZARÁN PARA MANIPULAR LA TABLA
    MÁS QUE TODO SON DATOS FIJOS COMO  FILAS Y COLUMNAS, ES DECIR SUS NOMBRES Y POSISIONES
    SU CONTENIDO SÍ CAMBIARÁ PERO EL RESTO NO
    */
    
    
    //LA TABLA TENDRÁ UN TOTAL DE 5 FILAS Y 8 COLUMNAS
    private final int MAX_FILAS = 5;
    private final int MAX_COLUMNAS = 8;

    
    // SE DECLARA UN ARREGLO DE DOS DIMENSIONES DE TIPO STRING QUE SE LLAMA FACTURA
    //AQUÍ ESTAMOS DEFINIENDO LA TABLA COMO TAL
    // COMO DIMENSIONES SE LE PASAN LAS CONSTANTES QUE SE DECLARARON ARRIBA
    private final String[][] factura = new String[MAX_FILAS][MAX_COLUMNAS];

    private final int UNIDADES = 0;
    private final int PRODUCTO = 1;
    private final int PRECIO = 2;
    private final int GASTO_VALOR = 3;
    private final int GASTO_PESO = 4;
    private final int COSTO_UNIDAD = 5;
    private final int COSTO_TOTAL = 6;
    private final int PESO = 7;

    
    
    /*
    ESTOS SON LOS DATOS PLANTEADOS EN EL EJERCICIO, SON GASTOS QUE DEBEN SER TOMADOS ENCUENTA PARA
    EL PORRATEO DE FACTURAS
    */
    private final double SEGURO_LOCAL = 3500.0;
    private final double FLETE = 2500.0;
    private final double IMPUESTOS = 5000.0;
    private final double ACARREO = 5000.0;
    private final double COMISIONES = 200.0;

    
    /*
    VARIABLES QUE SE UTILIZARÁN EN LOS PASOS DONDE SE REALIZAN CÁLCULOS
    ESTAS VARIABLES VAN A SUSTITUIR LOS VALORES EN CERO DE LA TABLA
    */
    
    private double granTotal = 0;
    private double valorTotal = 0;
    private double gastosValor = 0;
    private double gastosPeso = 0;
    private double coeficienteGasto = 0;
    private double coeficienteGastoPeso = 0;
    private double pesoTotal = 0;

    private int filaActual = 1;

    public void llenadoDatos() {

        
        /*
        EL PRIMER MÉTODO CONSISTE EN PONERLE ENCABEZADO A LA TABLA
        */
        llenarEncabezado();

        TablaFactura dato1 = new TablaFactura(50, "BOLSAS CEMENTO", 60, 0, 0, 0, 0, 50);
        agregarDatoMatriz(dato1);
        TablaFactura dato2 = new TablaFactura(150, "BALSAS CAL", 40, 0, 0, 0, 0, 20);
        agregarDatoMatriz(dato2);
        TablaFactura dato3 = new TablaFactura(200, "TUBOS PVC", 55, 0, 0, 0, 0, 10);
        agregarDatoMatriz(dato3);
        TablaFactura dato4 = new TablaFactura(50, "QUINTALES HIERRO", 350, 0, 0, 0, 0, 50);
        agregarDatoMatriz(dato4);
    }

    public void llenarEncabezado() {
        
        /*
        ESTE ENCABEZADO SE HA HECHO DINÁMICO, SE CONSTRUYE UN ARREGLO DE UNA DIMENSIÓN DE TIPO STRING
        Y COMO DATOS SE LE INGRESA LO QUE QUEREMOS QUE TENGA EL ENCABEZADO DE LA TABLA
        */
        String[] encabezado = {"UNIDADES", "PRODUCTO", "PRECIO", "GASTOS AL VALOR", "GASTOS AL PESO", "COSTO UNITARIO", "COSTO TOTAL", "PESO"};
        
        /*
        CON EL CICLO FOR SE RECORRE EL ARREGLO Y SE LE INDICA QUE EN CADA ITERACIÓN VAYA INSERTANDO LOS DATOS DEL ARREGLO ANTERIOR,
        ES DECIR, EN LA PRIMERA ITERACIÓN INSERTA "UNIDADES" EN LAS FILA 0, COLUMNA 0. LUEGO EN LA FILA 0, COLUMNA 1 INSERTA "PRODUCTOS Y
        ASÍ SUCESIVAMENTE.
        */
        for (int e = 0; e < encabezado.length; e++) {
            factura[0][e] = encabezado[e];
        }
    }

    public void agregarDatoMatriz(TablaFactura dato) {
        
        /*
        ESTE MÉTODO RECIBE COMO PARÁMETRO UN DATO DE "TABLAFACTURA" 
        EN CADA FILA Y COLUMNA SE VA INSERTANTO LO QUE CON TIENE EL PARÁMETRO
        ES DECIR, para el arreglo factura, en la fila 1 y columna 0 inserta unidades
        en la fila 1 columna1 inserta producto,
        en la fila 1 columna2 inserta precio y así sucesivamente
        */
        
        factura[filaActual][UNIDADES] = (String.valueOf(dato.getUnidades()));
        factura[filaActual][PRODUCTO] = dato.getProducto();
        factura[filaActual][PRECIO] = (String.valueOf(dato.getPrecio()));
        factura[filaActual][GASTO_VALOR] = (String.valueOf(dato.getGastoValor()));
        factura[filaActual][GASTO_PESO] = (String.valueOf(dato.getGastoPeso()));
        factura[filaActual][COSTO_UNIDAD] = (String.valueOf(dato.getCostoUnidad()));
        factura[filaActual][COSTO_TOTAL] = (String.valueOf(dato.getCostoTotal()));
        factura[filaActual][PESO] = (String.valueOf(dato.getPeso()));

        /*
        AL TERMINAR DE INSERTAR LOS DATOS EN EL ARREGLO LE AUMENTA UN NÚMERO A LA FILA
        ESTO ES PARA QUE EL SIGUIENTE DATO SE INSERTE EN LA FILA DE ABAJO
        CADA DATO QUE SE RECIBA SE VA IR INSERTANDO ABAJO DEL ANTERIOR POR ESO SE LE SUMA 1
        */
        filaActual = filaActual + 1;
    }

    public void paso1() {
        System.out.println("PASO 1: En este primer paso se va a multiplicar el valor de cada unidad por el número de unidades: ");

        for (int f = 0; f < factura.length; f++) {
            //EN EL PRIMER CICLO FOR RECORREMOS LA FILA, ES DECIR POR CADA ITERACIÓN RECORREMOS UNA FILA HASTA LLEGAR AL FINAL DE LA TABLA
            for (int c = 0; c < MAX_COLUMNAS; c++) {
                /*
                EN ESTE CICLO FOR ESTAMOS EN LAS COLUMNAS
                LA CONDICIÓN DICE si f es mayor que 0, ESO SE HACE PORQUE LA PRIMERA FILA TIENE EL ENCABEZADO
                LOS CÁLCULOS SE HACEN A PARTIR DE LA FILA 2
                
                LA OTRA DONCIÓN ES si columna es igual a costototal, ESTO ES PARA HACER EL CÁLCULO EN LA COLUMNA DE TOTAL
                */
                if (f > 0 && c == COSTO_TOTAL) {
                    
                    //MULTIPLICAMOS EL PRECIO DEL PRODUCTO POR LAS UNIDADES Y LO GUARDAMOS EN LA VARIABLE VALORTOTAL
                    //LUEGO ESA VARIABLE SE SUMA A SÍ MISMA CON EL NUEVO VALOR PARA QUE VAYA AUMENTANDO Y ASÍ OBTENEMOS EL GRAN TOTAL
                    factura[f][c] = String.valueOf((Integer.parseInt(factura[f][UNIDADES]) * Double.parseDouble(factura[f][PRECIO])));
                    valorTotal = valorTotal + Double.parseDouble(factura[f][c]);
                }

                System.out.print(factura[f][c] + " |");
            }

            System.out.println("");
        }
        System.out.println("TOTAL FACTURA: Q" + valorTotal + "\n");
    }

    public void paso2() {
        
        //EN ESTE PASO SOLO SE SUMAN LOS GASTOS Y SE GUARDAN EN LA VARIABLE gastosValor
        System.out.println("PASO 2: En este paso se va a sumar  los gastos que generaron en valor, para obtener el total del gasto al valor: ");
        System.out.println("Seguro de local: Q" + SEGURO_LOCAL);
        System.out.println("Impuestos: Q" + IMPUESTOS);
        System.out.println("Comisiones: Q" + COMISIONES);
        gastosValor = SEGURO_LOCAL + IMPUESTOS + COMISIONES;
        System.out.println("Gastos al valor: Q" + gastosValor + "\n");
    }

    public void paso3() {
        //EN LA VARIABLE coeficienteGasto SE REALIZA LA DIVISÓN DEL VALOR TOTAL DE LA FACTURA ENTRE LO QUE SE HA GASTADO EN VALORES
        System.out.println("PASO 3: - Es establecer el coeficiente del gasto en la cual  se obtiene dividiendo el total de gastos al valor entre el valor total de los materiales según su precio de factura: TotalGastos / TotalFactura = Q" + gastosValor + " / " + valorTotal);
        coeficienteGasto = gastosValor / valorTotal;
        System.out.println("Coeficiente del gasto al valor: " + coeficienteGasto + "\n");
    }

    public void paso4() {
        System.out.println("PASO 4: En este paso se va a obtener los gastos al valor  que genera cada producto y se obtiene multiplicando el valor de cada unidad por el coeficiente de gastos al valo = Precio * coeficiente");

        for (int f = 0; f < factura.length; f++) {

            if (f > 0) {

                /*
                CON ESTE CICLO FOR RECORREMOS LA TABLA Y VAMOS SACANDO EL COEFICIENTE PARA CADA PRODUCTO Y
                LO MOSTRAMOS PARA VER CÓMO VA QUEDANDO
                */
                double gastoValorProducto = Double.parseDouble(factura[f][PRECIO]) * coeficienteGasto;
                System.out.println(factura[f][PRECIO] + " * " + coeficienteGasto + " = " + gastoValorProducto);
            }

        }
        System.out.println("");
    }

    private void paso5() {
        System.out.println("PASO 5:  Se va a establecer el peso total de la mercadería, se obtiene multiplicando el peso de cada unidad por el número de unidades = Peso * Unidad");

        for (int f = 0; f < factura.length; f++) {

            /*
            TAMBIÉN RECORREMOS LA TABLA Y VAMOS SACANDO EL PESO DE CADA PRODUCTO Y LO MULTIPLICAMOS POR EL NÚMERO DE UNIDADES
            DE ESTA FORMA OBTENEMOS EL PESO INDIVIDUAL Y POR ENDE EL PESO TOTAL
            */
            
            if (f > 0) {

                double pesoFila = (Double.parseDouble(factura[f][PESO]) * Double.parseDouble(factura[f][UNIDADES]));
                pesoTotal = pesoTotal + pesoFila;
                System.out.println(factura[f][PESO] + "kg * " + factura[f][UNIDADES] + " = " + pesoFila);
            }

        }

        System.out.println("Peso Total = " + pesoTotal + " kilogramos\n");
    }

    private void paso6() {
        
        // AQUÍ SOLO SUMAMOS LOS GASTOS EN PESO, ES DECIR EL FLETE Y EL ACARREO SE SUMAN
        System.out.println("PASO 6: se va a establecer los gastos que generaron el peso de los productos en la cual se obtiene al sumarlo. ");
        System.out.println("Flete: Q" + FLETE);
        System.out.println("Acarreo: Q" + ACARREO);

        gastosPeso = FLETE + ACARREO;
        System.out.println("Gastos al peso: Q" + gastosPeso + "\n");
    }

    private void paso7() {
        //SE HACE UNA VISIÒN PARA OBTENER EL COEFICIENTE. EL GASTO EN PESOS SE DIVIDE EN EL PESO TOTAL
        System.out.println("PASO 7 - establecer el coeficiente del gasto, que se obtiene dividiendo el total de gastos entre el peso total: TotalGastosPeso / TotalPeso = Q" + gastosPeso + " / " + pesoTotal);
        coeficienteGastoPeso = gastosPeso / pesoTotal;
        System.out.println("Coeficiente del gasto al peso: " + coeficienteGastoPeso + "\n");

    }

    private void paso8() {
        System.out.println("PASO 8: Se va a determinar los gastos al peso que generaron cada producto en la cual  se obtiene multiplicando el peso de cada unidad por el coeficiente del gasto al valorse va a determinar los gastos al peso que generaron cada producto en la cual  se obtiene multiplicando el peso de cada unidad por el coeficiente del gasto al valor");

        for (int f = 0; f < factura.length; f++) {

            if (f > 0) {
                /*
                ESE COEFICIENTE QUE SACAMOS LO MULTIPLICAMOS POR EL ESO DE CADA PRODUCTO
                AQUÌ RECORREMOS LA TABLA OTRA VEZ FILA POR FILA Y HACEMOS LA MULTIPLICACIONES ENTRE ESE DATO Y EL COEFICIENTE Y LO MOSTRAMOS EN PANTALLA
                */
                double gastoPesoP = Double.parseDouble(factura[f][PESO]) * coeficienteGastoPeso;
                System.out.println(factura[f][PESO] + " * " + coeficienteGastoPeso + " = " + gastoPesoP);
            }

        }
        System.out.println("");
    }

    private void paso9() {
        System.out.println("Paso 9: se va elaborar un cuadro en donde se va a registrar  el costo unitario y  el costo total: ");

        for (int f = 0; f < factura.length; f++) {

            for (int c = 0; c < MAX_COLUMNAS; c++) {

                /*
                VOLVEMOS A RECORRER LA TABLA, ESTA VEZ PARA INGRESAR TODOS LOS DATOS QUE HEMOS CALCULADO
                HASTA AHORA SOLO LOS HABÌAMOS CALCULADO Y MOSTRADO PERO NO LOS HABÌAMOS INGRESADO A LA MATRÌZ
                
                */
                
                if (f > 0) {
                    
                    //HACEMOS CADA OPERACIÒN Y SE LO ASIGNAMOS A LA POSISIÒN DE FILA Y COLUMNA QUE CORRESPONDE CADA CÀCULO
                    double gastoValorProducto = Double.parseDouble(factura[f][PRECIO]) * coeficienteGasto;
                    factura[f][GASTO_VALOR] = String.valueOf(gastoValorProducto);

                    double gastoPesoP = Double.parseDouble(factura[f][PESO]) * coeficienteGastoPeso;
                    factura[f][GASTO_PESO] = String.valueOf(gastoPesoP);

                    double costoUnidad = (Double.parseDouble(factura[f][PRECIO]) + gastoValorProducto + Double.parseDouble(factura[f][GASTO_PESO]));
                    factura[f][COSTO_UNIDAD] = String.valueOf(costoUnidad);

                    double costoTotal = Double.parseDouble(factura[f][UNIDADES]) * costoUnidad;
                    factura[f][COSTO_TOTAL] = String.valueOf(costoTotal);

                    if (c == COSTO_TOTAL) {
                        // ESTA CONDICIÒN ES PARA QUE EN UNA VARIABLE SE GUARDE EL GRAN TOTAL Y LO TENGAMOS LISTO PARA EL
                        //ÙLTIMO PASO
                        granTotal = granTotal + Double.parseDouble(factura[f][COSTO_TOTAL]);
                    }
                }

                System.out.print(factura[f][c] + " |");
            }

            System.out.println("");
        }
        System.out.println("GRAN TOTAL: Q" + granTotal + "\n");
    }

    private void paso10() {
        /*
        AQUÌ SUMAMOS EL VALOR TOTAL DE LA PRIMERA FACTURA CON LOS GASTOS AL VALOR Y LOS GASTOS AL PESO
        ESA SUMA TIENE QUENCOINCIDIR CON EL GRAN TOTAL
        */
        System.out.println("PASO 10: En este paso se realiza la comprobación de que el ejercicio se haya resuelto correctamente, se suma el total según el precio de factura, el total de gastos al valor y el total de gastos al peso. El total debe de coincidir con el total del cuadro anterior");
        System.out.println("Total según factura: Q" + valorTotal);
        System.out.println("Total de gastos al valor: Q" + gastosValor);
        System.out.println("Total de gasto al peso: Q" + gastosPeso);

        System.out.println("GRAN TOTAL: Q" + granTotal + "\n");
    }

    public void mostrarDatos() {
        
        /*
        ESTE MÉTODO SIRVE PARA LLAMAR TODOS LOS PASOS EN ORDEN Y ASÍ TENER EL CÓDIGO SEPARADO,
        ES DECIR, TENEMOS UN MÉTODO PARA CADA PASO DEL EJERCICIO Y NO TODO EL CÓDIGO JUNTO
        */
        
        paso1();
        paso2();
        paso3();
        paso4();
        paso5();
        paso6();
        paso7();
        paso8();
        paso9();
        paso10();
    }

}
