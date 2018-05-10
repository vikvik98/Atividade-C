package model;

public class Boneco {

    private String corpo;

    public void preencherBoneco(int contErros){
        switch(contErros)
        {
            case 0:
                corpo = "  __ \n";
                corpo += "|\t \n";
                corpo += "|\t \n";
                corpo += "|\t \n";
                break;
            case 1:
                corpo = "  __ O \n";
                corpo += "|\t \n";
                corpo += "|\t \n";
                corpo += "|\t \n";
                break;
            case 2:
                corpo = "  __  O \n";
                corpo += "|        | \n";
                corpo += "|\n";
                corpo += "|\n";
                break;
            case 3:
                corpo = "  __  O \n";
                corpo += "|       -|-\n";
                corpo += "|\n";
                corpo += "|\n";
                break;
            case 4:
                corpo = "  __  O \n";
                corpo += "|       -|-\n";
                corpo += "|       | \n";
                corpo += "|\n";
                break;
            case 5:
                corpo = "  __  O \n";
                corpo += "|       -|-\n";
                corpo += "|       |  | \n";
                corpo += "|        \n";
                break;
        }
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }
}
