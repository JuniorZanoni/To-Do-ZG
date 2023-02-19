package service.task

class ListTasks {
    List<Task> listTasks

    ListTasks(List<Task> listTasks) {
        this.listTasks = listTasks
    }

    List<Map> getListAllBO() {
        return convertTasksInBO(listTasks)
    }

    List<Map> getListByCategoryBO(String category) {
        List<Task> listByCategory = listTasks.findAll(task -> task.category == category)
        return convertTasksInBO(listByCategory)
    }

    List<Map> getListByPriorityBO(Integer priority) {
        List<Task> listByPriority = listTasks.findAll(task -> task.priority == priority)
        return convertTasksInBO(listByPriority)
    }

    List<Map> getListByStatusBO(String status) {
        List<Task> listByStatus = listTasks.findAll(task -> task.status == status)
        return convertTasksInBO(listByStatus)
    }

    List<Map> getListByDateBO(String date) {
        List<Task> listByDate = listTasks.findAll(task -> task.getDateCreate() == date)
        return convertTasksInBO(listByDate)
    }

    void verifyTask(Integer indexTask) {
        listTasks.get(indexTask)
    }

    private List<Map> convertTasksInBO(List<Task> listTasks) {
        List<Map> list = []

        listTasks.forEach {task -> {
            list.add([
                    nome: task.name,
                    descricao: task.description,
                    categoria: task.category,
                    status: task.status,
                    prioridade: task.priority
            ])
        }}

        return list
    }
}
