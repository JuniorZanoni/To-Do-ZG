package model

import service.task.Task

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ModelTask {
    void save(Task task) {
        List<Task> listTasks = getAllTasks()
        listTasks.add(task)
        saveAllTasks(listTasks)
    }

    List<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>()

        try {
            Scanner scanner = new Scanner(new File("tasks.csv"))

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine()
                List<String> values = line.split(",")

                String name = values[0]
                String description = values[1]
                Integer priority = values[2].toInteger()
                String status = values[3]
                String category = values[4]

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                LocalDate date = LocalDate.parse(values[5], formatter)

                Task task = new Task(name, description, category, status, priority, date)

                tasks.add(task)
            }

            scanner.close()
        } catch (Exception ignored) {
            return []
        }

        return tasks
    }

    Task getTaskById(Integer indexTask) {
        List<Task> tasks = getAllTasks()
        return tasks.get(indexTask)
    }

    void update(Task task, Integer index) {
        List<Task> listTasks = getAllTasks()
        listTasks[index] = task
        saveAllTasks(listTasks)
    }

    void delete(Integer index) {
        ArrayList<Task> listTasks = getAllTasks()
        listTasks.remove(index)
        saveAllTasks(listTasks)
    }

    private void saveAllTasks(List<Task> listTasks) {
        PrintStream ps = new PrintStream("tasks.csv")

        listTasks.forEach(element -> {
            ps.print(element.getName())
            ps.print(",")
            ps.print(element.getDescription())
            ps.print(",")
            ps.print(element.getPriority())
            ps.print(",")
            ps.print(element.getStatus())
            ps.print(",")
            ps.print(element.getCategory())
            ps.print(",")
            ps.print(element.getDateCreate())
            ps.println()
        })

        ps.close()
    }
}
