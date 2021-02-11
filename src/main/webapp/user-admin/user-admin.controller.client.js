var $usernameFld, $passwordFld;
var $firstNameFld, $lastNameFld, $roleFld;
var $removeBtn, $editBtn, $createBtn, $updateBtn;
var $userRowTemplate, $tbody;
var userService = new AdminUserServiceClient();

var users = [];

function createUser(user) {
    userService.createUser(user)
        .then(function (actualUser) {
            users.push(actualUser)
            renderUsers(users)
        })
}

function deleteUser(event) {
    console.log(event.target);
    var deleteBtn = jQuery(event.target);
    var theClass = deleteBtn.attr("class")
    var theIndex = deleteBtn.attr("id")
    var theId = users[theIndex]._id
    console.log(theClass)
    console.log(theIndex)

    userService.deleteUser(theId)
        .then(function (status) {
            users.splice(theIndex, 1)
            renderUsers(users)
        })
}

var selectedUser = null
function selectUser(event) {
    var selectBtn = jQuery(event.target)
    var theId = selectBtn.attr("id")
    selectedUser = users.find(user => user._id === theId)
    $usernameFld.val(selectedUser.username)
    $passwordFld.val(selectedUser.password)
    $firstNameFld.val(selectedUser.firstName)
    $lastNameFld.val(selectedUser.lastName)
    $roleFld.val(selectedUser.role)
}

function updateUser() {
    console.log(selectedUser)
    selectedUser.username = $usernameFld.val()
    selectedUser.password = $passwordFld.val()
    selectedUser.firstName = $firstNameFld.val()
    selectedUser.lastName = $lastNameFld.val()
    selectedUser.role = $roleFld.val()
    userService.updateUser(selectedUser._id, selectedUser)
        .then(function (status) {
            var index = users.findIndex(user => user._id === selectedUser._id)
            users[index] = selectedUser
            renderUsers(users)
        })
}

function renderUsers(users) {
    $tbody.empty()
    for (var i = 0; i < users.length; i++) {
        var user = users[i]
        $tbody
            .append(`
            <tr>
                <td>${user.username}</td>
                <td>&nbsp</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.role}</td>
                <td><span class="float-right">
                    <i class="fa-2x fa fa-times wbdv-remove" id="${i}"></i>
                    <i class="fa-2x fa fa-pencil wbdv-edit" id="${user._id}"></i>
                </span></td>
            </tr>
            `)
    }
    jQuery(".wbdv-remove")
        .click(deleteUser)
    jQuery(".wbdv-edit")
        .click(selectUser)
    $usernameFld.val("")
    $passwordFld.val("")
    $firstNameFld.val("")
    $lastNameFld.val("")
}

function findAllUsers() { } // optional - might not need this
function findUserById() { } // optional - might not need this

function main() {
    $usernameFld = $("#usernameFld")
    $passwordFld = $("#passwordFld")
    $firstNameFld = $("#firstNameFld")
    $lastNameFld = $("#lastNameFld")
    $roleFld = $("#roleFld")

    $removeBtn = $(".wbdv-remove")
    $editBtn = $(".wbdv-edit")
    $createBtn = $("#createBtn")
    $updateBtn = $("#updateBtn")

    $removeBtn.click(deleteUser)
    $editBtn.click(selectUser)
    $createBtn.click(() => {
        //console.log('create');
        createUser({
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            role: $roleFld.val()
        })
            $usernameFld.val("")
            $passwordFld.val("")
            $firstNameFld.val("")
            $lastNameFld.val("")
       }
    )
    $updateBtn.click(updateUser);

    $userRowTemplate = $(".wbdv-template.wbdv-user");
    $tbody = $(".wbdv-tbody");

    userService.findAllUsers()
        .then(function (actualUsersFromServer){
            users = actualUsersFromServer
            renderUsers(users)
        })
}
jQuery(main)
