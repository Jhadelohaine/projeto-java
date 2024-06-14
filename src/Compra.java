public class Compra {
    private String[] itens;
    private double[]  precos;

    public Compra(String[] itens, double[] precos) {
        this.itens = itens;
        this.precos = precos;

    }

    public double calcularValor(){
       double total = 0;
    for (int i = 0; i < itens.length; i++) {
        total += precos[i];
    }
    return total;
}

   public void exibirItens() {
       System.out.println("Itens da compra:");
       for (int i = 0; i < itens.length; i++){
           System.out.println(itens[i] + ":R$" + precos[i]);
       }

   }

   public static void main(String[] args){
        String[] itens = {"Pão", "Leite", "manteiga"};
        double[] precos = {2.5, 3.0, 5.0};
        Compra compra = new Compra(itens, precos);

        compra.exibirItens();
        System.out.println("valor total da compra: R$"  + compra.calcularValor());
        }
}



















