fillInPrincipal();

/*function rolesToString(roles) {
    let rolesAsString = '';
    roles.forEach((singleRole) => {
        rolesAsString += singleRole.name + " ";
    })
    return rolesAsString;
}*/

function fillInPrincipal() {
    fetch("http://localhost:8080/user/userList")
        .then(res => res.json())
        .then(user => {
            console.log('userSata', JSON.stringify(user))
            $('#headerUserName').append(user.email);
            /*let roles = data.roles.map(r => " " + r.name.substring(5));*/
            let roles = user.roles.map(role => role.role.substring(5).concat(" ")).toString().replaceAll(",", "");
            $('#headerRole').append(roles);
            let userList = `$(
                <tr>
                    <td>${user.id}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.age}</td>   
                    <td>${user.email}</td>
                    <td>${roles}</td>
                </tr>)`;
            $('#userTable').append(userList);
        })
}