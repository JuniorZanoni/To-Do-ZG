package view.MenuListTasks

import service.task.ListTasks

class MenuListAllTasks {
    ListTasks listTasks

    MenuListAllTasks(ListTasks listTasks) {
        this.listTasks = listTasks
    }

    void menu() {
        listTasks.getListAllBO().forEach { println "${it.nome} - ${it.descricao} - ${it.categoria} - ${it.status} - ${it.prioridade}"}
    }
}
