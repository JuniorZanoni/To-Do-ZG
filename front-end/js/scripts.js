let tasks = [];
let checks = [];
getLocalStorage();
createForm();
createFilter();
createList();
selectMultiTasks();

function getLocalStorage() {
  if (localStorage.getItem("tasks")) {
    tasks = JSON.parse(localStorage.getItem("tasks"));
  }
}

function createForm() {
  const box = document.getElementById("box");

  const form = document.createElement("form");
  form.id = "form-create-task";
  form.className = "form-create-task";

  const inputTask = document.createElement("input");
  inputTask.name = "task";
  inputTask.id = "input-task";
  inputTask.placeholder = "Tarefa";
  inputTask.type = "text";
  inputTask.required = "true";
  form.append(inputTask);

  const inputDescription = document.createElement("input");
  inputDescription.name = "description";
  inputDescription.id = "input-description";
  inputDescription.placeholder = "Descrição";
  inputDescription.type = "text";
  inputDescription.required = "true";
  form.append(inputDescription);

  const inputSelectStatus = document.createElement("select");
  inputSelectStatus.id = "input-status";
  inputSelectStatus.name = "status";
  const optionStatus1 = document.createElement("option");
  optionStatus1.disabled = true;
  optionStatus1.selected = true;
  optionStatus1.hidden = true;
  optionStatus1.innerText = "Status";
  const optionStatus2 = document.createElement("option");
  optionStatus2.innerText = "A fazer";
  optionStatus2.value = "A fazer";
  const optionStatus3 = document.createElement("option");
  optionStatus3.innerText = "Fazendo";
  optionStatus3.value = "Fazendo";
  const optionStatus4 = document.createElement("option");
  optionStatus4.innerText = "Feito";
  optionStatus4.value = "Feito";
  inputSelectStatus.append(optionStatus1);
  inputSelectStatus.append(optionStatus2);
  inputSelectStatus.append(optionStatus3);
  inputSelectStatus.append(optionStatus4);
  form.append(inputSelectStatus);

  const inputSelectPriority = document.createElement("select");
  inputSelectPriority.id = "priority";
  inputSelectPriority.name = "priority";
  inputSelectPriority.required = "true";
  const optionPriority = document.createElement("option");
  optionPriority.disabled = true;
  optionPriority.selected = true;
  optionPriority.hidden = true;
  optionPriority.innerText = "Prioridade";
  const optionPriority1 = document.createElement("option");
  optionPriority1.innerText = "1";
  const optionPriority2 = document.createElement("option");
  optionPriority2.innerText = "2";
  const optionPriority3 = document.createElement("option");
  optionPriority3.innerText = "3";
  const optionPriority4 = document.createElement("option");
  optionPriority4.innerText = "4";
  const optionPriority5 = document.createElement("option");
  optionPriority5.innerText = "5";
  inputSelectPriority.appendChild(optionPriority);
  inputSelectPriority.appendChild(optionPriority1);
  inputSelectPriority.appendChild(optionPriority2);
  inputSelectPriority.appendChild(optionPriority3);
  inputSelectPriority.appendChild(optionPriority4);
  inputSelectPriority.appendChild(optionPriority5);
  form.append(inputSelectPriority);

  const btnAddTask = document.createElement("button");
  btnAddTask.innerText = "Salvar";
  form.append(btnAddTask);

  btnAddTask.addEventListener("click", (e) => {
    const name = inputTask.value;
    const description = inputDescription.value;
    const status = inputSelectStatus.value;
    const priority = inputSelectPriority.value;

    if (
      name == "" ||
      description == "" ||
      priority == "Prioridade" ||
      status == "Status"
    ) {
      alert("Preencha todos os campos");
    } else {
      tasks.push({
        name,
        description,
        status,
        priority,
      });
      localStorage.setItem("tasks", JSON.stringify(tasks));
    }
  });

  box.appendChild(form);
}

function createItemList(name, description, status, priority) {
  const box = document.getElementById("box");
  let id = name + description;

  const form = document.createElement("form");

  const checkbox = document.createElement("input");
  checkbox.type = "checkbox";
  checkbox.name = "name";
  checkbox.value = "value";
  checkbox.id = "id";
  form.appendChild(checkbox);
  checkbox.addEventListener("change", (e) => {
    if (e.target.checked) {
      checks.push(name + description);
    } else {
      checks = checks.filter((check) => check != name + description);
    }
  });

  const inputTask = document.createElement("input");
  inputTask.name = "task";
  inputTask.id = "task";
  inputTask.type = "text";
  inputTask.required = "true";
  inputTask.value = name;
  form.append(inputTask);

  const inputDescription = document.createElement("input");
  inputDescription.name = "description";
  inputDescription.id = "description";
  inputDescription.type = "text";
  inputDescription.required = "true";
  inputDescription.value = description;
  form.append(inputDescription);

  const inputSelectStatus = document.createElement("select");
  inputSelectStatus.id = "status";
  inputSelectStatus.name = "status";
  inputSelectStatus.required = true;
  const optionStatus2 = document.createElement("option");
  optionStatus2.innerText = "A fazer";
  optionStatus2.value = "A fazer";
  optionStatus2.selected = status == "A fazer" ? true : false;
  const optionStatus3 = document.createElement("option");
  optionStatus3.innerText = "Fazendo";
  optionStatus3.value = "Fazendo";
  optionStatus3.selected = status == "Fazendo" ? true : false;
  const optionStatus4 = document.createElement("option");
  optionStatus4.innerText = "Feito";
  optionStatus4.value = "Feito";
  optionStatus4.selected = status == "Feito" ? true : false;
  inputSelectStatus.append(optionStatus2);
  inputSelectStatus.append(optionStatus3);
  inputSelectStatus.append(optionStatus4);
  form.append(inputSelectStatus);

  const inputSelectPriority = document.createElement("select");
  inputSelectPriority.id = "priority";
  inputSelectPriority.name = "priority";
  inputSelectPriority.required = "true";
  const optionPriority1 = document.createElement("option");
  optionPriority1.innerText = "1";
  optionPriority1.selected = priority == "1" ? true : false;
  const optionPriority2 = document.createElement("option");
  optionPriority2.innerText = "2";
  optionPriority2.selected = priority == "2" ? true : false;
  const optionPriority3 = document.createElement("option");
  optionPriority3.innerText = "3";
  optionPriority3.selected = priority == "3" ? true : false;
  const optionPriority4 = document.createElement("option");
  optionPriority4.innerText = "4";
  optionPriority4.selected = priority == "4" ? true : false;
  const optionPriority5 = document.createElement("option");
  optionPriority5.innerText = "5";
  optionPriority5.selected = priority == "5" ? true : false;
  inputSelectPriority.appendChild(optionPriority1);
  inputSelectPriority.appendChild(optionPriority2);
  inputSelectPriority.appendChild(optionPriority3);
  inputSelectPriority.appendChild(optionPriority4);
  inputSelectPriority.appendChild(optionPriority5);
  form.append(inputSelectPriority);

  const btnEdit = document.createElement("button");
  btnEdit.innerText = "Salvar edição";
  btnEdit.addEventListener("click", (e) => {
    const name = inputTask.value;
    const description = inputDescription.value;
    const status = inputSelectStatus.value;
    const priority = inputSelectPriority.value;

    tasks.forEach((e, i) => {
      if (e.name + e.description == id) {
        id = i;
      }
    });

    tasks[id] = {
      name,
      description,
      status,
      priority,
    };

    localStorage.setItem("tasks", JSON.stringify(tasks));
  });

  const btnDelete = document.createElement("button");
  btnDelete.innerText = "Excluir";
  btnDelete.addEventListener("click", (e) => {
    tasks = tasks.filter((e) => e.name + e.description != id);
    localStorage.setItem("tasks", JSON.stringify(tasks));
  });
  form.append(btnDelete);

  form.append(btnEdit);

  box.appendChild(form);
}

function createList() {
  const filter = localStorage.getItem("filter");

  switch (filter) {
    case "A fazer":
      tasks
        .filter((e) => e.status == "A fazer")
        .forEach((e) =>
          createItemList(e.name, e.description, e.status, e.priority)
        );
      break;
    case "Fazendo":
      tasks
        .filter((e) => e.status == "Fazendo")
        .forEach((e) =>
          createItemList(e.name, e.description, e.status, e.priority)
        );
      break;
    case "Feito":
      tasks
        .filter((e) => e.status == "Feito")
        .forEach((e) =>
          createItemList(e.name, e.description, e.status, e.priority)
        );
      break;
    case "Todas":
      tasks.forEach((e) =>
        createItemList(e.name, e.description, e.status, e.priority)
      );
      break;
  }
}

function createFilter() {
  const box = document.getElementById("box");
  const boxDiv = document.createElement("div")
  boxDiv.className = "box-filter"
  const filterSelected = localStorage.getItem("filter");

  const filter = document.createElement("select");
  filter.name = "filter";
  filter.id = "filter";
  filter.name = "filter";
  const optionStatus1 = document.createElement("option");
  optionStatus1.innerText = "Todas";
  optionStatus1.value = "Todas";
  optionStatus1.selected = !filterSelected ? true : false;
  const optionStatus2 = document.createElement("option");
  optionStatus2.innerText = "A fazer";
  optionStatus2.value = "A fazer";
  optionStatus2.selected = filterSelected == "A fazer" ? true : false;
  const optionStatus3 = document.createElement("option");
  optionStatus3.innerText = "Fazendo";
  optionStatus3.value = "Fazendo";
  optionStatus3.selected = filterSelected == "Fazendo" ? true : false;
  const optionStatus4 = document.createElement("option");
  optionStatus4.innerText = "Feito";
  optionStatus4.value = "Feito";
  optionStatus4.selected = filterSelected == "Feito" ? true : false;
  filter.append(optionStatus1);
  filter.append(optionStatus2);
  filter.append(optionStatus3);
  filter.append(optionStatus4);

  const label = document.createElement("label");
  label.innerText = "Mostrar tarefas:";

  filter.addEventListener("click", (e) => {
    localStorage.setItem("filter", e.target.value);
    window.location.reload(true);
  });

  boxDiv.appendChild(label)
  boxDiv.appendChild(filter)
  box.appendChild(boxDiv);
}

function selectMultiTasks() {
  const box = document.getElementById("box");

  const boxDiv = document.createElement("div")
  boxDiv.className = "box-multiTask"

  const filter = document.createElement("select");
  filter.name = "filter";
  filter.id = "filter";
  filter.name = "filter";
  const optionStatus2 = document.createElement("option");
  optionStatus2.innerText = "A fazer";
  optionStatus2.value = "A fazer";
  const optionStatus3 = document.createElement("option");
  optionStatus3.innerText = "Fazendo";
  optionStatus3.value = "Fazendo";
  const optionStatus4 = document.createElement("option");
  optionStatus4.innerText = "Feito";
  optionStatus4.value = "Feito";

  filter.append(optionStatus2);
  filter.append(optionStatus3);
  filter.append(optionStatus4);

  const label = document.createElement("label");
  label.innerText = "Marcar tarefas selecionadas como:";

  filter.addEventListener("click", (e) => {
    console.log(checks);
    console.log(tasks);
    console.log(e.target.value);

    checks.forEach((check) => {
      tasks = tasks.map((task) => {
        if (task.name + task.description == check) {
          return {
            name: task.name,
            description: task.description,
            status: e.target.value,
            priority: task.priority,
          };
        } else {
          return task;
        }
      });
    });

    localStorage.setItem("tasks", JSON.stringify(tasks));
    window.location.reload(true);
  });

  boxDiv.appendChild(label)
  boxDiv.appendChild(filter)
  box.appendChild(boxDiv)
}
