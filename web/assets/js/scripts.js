function Confirm() {
    //var result = Confirm("Do you want to delete");
    var result = confirm("Are you sure you want to do this ?");
    if (!result) {
        event.preventDefault();
    }
}