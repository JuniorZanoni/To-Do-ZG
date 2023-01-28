function createForm() {
  const box = document.getElementById("box");
  const form = document.createElement("form");
  form.id = "form-create-task";

  form.appendChild(createInputTask());
  form.appendChild(createInputDescription());
  form.append(createInputSelectStatus());
  form.append(createInputSelectPriority());
  form.append(createInputSubmit());
  box.appendChild(form);

  const formCreateTask = document.getElementById("form-create-task");

  formCreateTask.addEventListener("submit", (e) => {
    const name = document.getElementById("input-task").value;
    const description = document.getElementById("input-description").value;
    const status = document.getElementById("input-status").value;
    const priority = document.getElementById("input-priority").value;

    saveTaskInLocalStorage(name, description, status, priority);
  });
}

function createInputTask() {
  const inputTask = document.createElement("input");
  inputTask.id = "input-task";
  inputTask.placeholder = "Tarefa";
  inputTask.type = "text";
  inputTask.required = "true";

  return inputTask;
}

function createInputDescription() {
  const inputDescription = document.createElement("input");
  inputDescription.id = "input-description";
  inputDescription.placeholder = "Descrição";
  inputDescription.type = "text";
  inputDescription.required = "true";

  return inputDescription;
}

function createInputSelectStatus() {
  const inputSelectStatus = document.createElement("select");
  inputSelectStatus.id = "input-status";
  inputSelectStatus.name = "status";
  inputSelectStatus.required = true;

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

  return inputSelectStatus;
}

function createInputSelectPriority() {
  const inputSelectPriority = document.createElement("select");
  inputSelectPriority.id = "input-priority";
  inputSelectPriority.name = "status";
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

  return inputSelectPriority;
}

function createInputSubmit() {
  const inputSubmit = document.createElement("input");
  inputSubmit.type = "submit";
  inputSubmit.value = "Salvar";
  return inputSubmit;
}
