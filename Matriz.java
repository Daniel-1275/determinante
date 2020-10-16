
import java.util.Scanner;
public final class Matriz {
    
    private int valor[][];
    private int fil;
    private int col;
    
    Scanner entrada = new Scanner(System.in);
    

    public int getFil() {
        return fil;
    }

    public void setFil(int fil) {
        this.fil = fil;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    public void rellenarValor(){
        for(int i = 0; i < getFil() ; i++){
            for(int j = 0; j < getCol() ; j++){
                System.out.print("Digite ["+(i+1)+"]["+(j+1)+"]: ");
                valor[i][j] = entrada.nextInt();
            }
        }
    }
    public void mostrarMatriz(){
       
        for(int i = 0 ; i < fil ; i++){
            for(int j = 0 ; j < col ; j++){
                System.out.print(" "+valor[i][j]);
            }
            System.out.println("");
        }
    }
    public void productoBoleeano(Matriz m1, Matriz m2){
        if(m1.col == m2.fil){
            
            fil = m1.fil;
            col = m2.col;
            valor = new int[fil][col];
            
            int k = 0;
            for(int i = 0 ; i < fil ; i ++){
                for(int j = 0 ; j < col ; j ++){
                    while(k != m1.col){
                        valor[i][j] += (m1.valor[i][k] * m2.valor[k][j]); 
                        k++;
                    }
                    k=0;
                }
            }
        }
        else{
            fil = 0;
            col = 0;
            System.out.println("No existe producto");
        }
    }
    
    public Matriz(){
        System.out.print("\nDigite el numero de filas: ");
        fil = entrada.nextInt();
        
        System.out.print("Digite el numero de columnas: ");
        col = entrada.nextInt();
        valor = new int[fil][col];
    }
    public Matriz(int fil, int col){
        this.fil = fil;
        this.col = col;
    }
    public int determinante(){
        int n = fil;
        int det = 0;
        if(fil == col){
            if(n == 2){
                det = determinante2x2();
            }
            else{
                for(int k = 0 ; k < fil ; k++){
                    det += (valor[0][k] * cofactor(0,k));
                }
            }
            
        }else{
            System.out.print("\nDeterminante no existe: "); 
            det = 0;
        }
        return det;
    }
    public Matriz(int n){
        fil = n;
        col = n;
        valor = new int[fil][col];
    }
    public int determinante2x2(){
        return (valor[0][0] * valor[1][1])-(valor[1][0] * valor[0][1]);
    }
    public int cofactor(int i,int j){
        // De un grado menor
        Matriz matriz_menor = new Matriz(fil-1);
        Matriz copia = new Matriz(fil);
        for(int a = 0 ; a < fil ; a ++){
            System.arraycopy(valor[a], 0, copia.valor[a], 0, fil);
        }
        //Moviendo filas
        for(int a = i ; a < fil-1 ; a ++){
            for(int b = 0 ; b < fil ; b ++){
                copia.valor[a][b] = copia.valor[a+1][b];
            }
        }
        //Moviendo columnas
        for(int b = j ; b < fil-1 ; b ++){
            for(int a = 0 ; a < fil ; a ++){
                copia.valor[a][b] = copia.valor[a][b+1];
            }
        }
        //Copiando a matriz_menor
        for(int a = 0 ; a < fil-1 ; a ++){
            System.arraycopy(copia.valor[a], 0, matriz_menor.valor[a], 0, fil-1);
        }
        
        return ((int)Math.pow(-1, i+j+2)) * matriz_menor.determinante();
    }
}
