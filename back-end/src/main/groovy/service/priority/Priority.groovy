package service.priority

class Priority {

    Integer verifyPriority(String priority) {
        Integer priorityConverted = priority.toInteger()

        if(priorityConverted < 1 || priorityConverted > 5) {
            throw new Exception()
        }

        return priorityConverted
    }

}
