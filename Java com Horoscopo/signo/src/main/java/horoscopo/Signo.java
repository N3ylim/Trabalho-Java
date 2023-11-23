public class Signo {
    public String determinar_signo(String data) {
        String[] parte_data = data.split("/");

        if (parte_data != 3) {
            return "dados inválidos";
        }

        int dia = interger.parseInt(parte_data[0]);
        int mes = interger.parseInt(parte_data[1]);

        if (mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return "dados inválidos";
        }

        switch (mes) {
            case 1:
                if (dia >= 20)
                    return "Aquário";
                else
                    return "Capricórnio";
            case 2:
                if (dia >= 19)
                    return "Peixes";
                else
                    return "Aquário";
            case 3:
                if (dia >= 21)
                    return "Áries";
                else
                    return "Peixes";
            case 4:
                if (dia >= 20)
                    return "Touro";
                else
                    return "Àries";
            case 5:
                if (dia >= 21)
                    return "Gêmeos";
                else
                    return "Touro";
            case 6:
                if (dia >= 21)
                    return "Câncer";
                else 
                    return "Gêmeos";
            case 7:
                if (dia >= 23)
                    return "Leão";
                else 
                    return "Câncer";
            case 8:
                if (dia >= 23)
                    return "Virgem";
                else 
                    return "Leão";
            case 9:
                if (dia >= 23)
                    return "Libra";
                else 
                    return "Virgem";
            case 10:
                if (dia >= 23)
                    return "Escorpião";
                else 
                    return "Libra";
            case 11:
                if (dia >= 22)
                    return "Sagitário";
                else 
                    return "Escorpião";
            case 12:
                    if (dia >= 22)
                        return "Capricórnio";
                    else 
                        return "Escorpião";
            default:
                return "dados inválidos";
            break;
        }
    }
}