package br.com.allpets.AllPets.components;

public class PlanoAnual implements TypePlan {
    private Double preco = 20.0;
    private Double multa = 0.0;
    private String status = "";

    @Override
    public Double pagamento() {
        return this.preco + this.multa;
    }

    @Override
    public String cancelamento(Boolean status) {
        if(status){
            this.status = "Cancelamento do plano anual concluido, ficaremos com saudade!";
        }
        return this.status;
    }

    @Override
    public String assinou(Boolean status) {
        if(status){
            this.status = "Assinatura anual feita com sucesso!";
        }
        return this.status;
    }

}
