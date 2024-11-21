const checkboxes = document.querySelectorAll('input[name="estagio"]');
checkboxes.forEach((checkbox) => {
    checkbox.addEventListener("change", () => {
    checkboxes.forEach((box) => {
        if (box !== checkbox) box.checked = false;
        });
    });
});
