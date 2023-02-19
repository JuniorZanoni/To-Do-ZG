package service.status

class Status {

    String verifyStatus(String status) {
        switch (status) {
            case "1":
                return "A fazer"
            case "2":
                return "Fazendo"
            case "3":
                return "Feito"
            default: throw new Exception()
        }
    }
}
