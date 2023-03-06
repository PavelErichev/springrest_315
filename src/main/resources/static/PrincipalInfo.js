fillInPrincipal();

function fillInPrincipal() {
    fetch("http://localhost:8080/user/userAuth")
        .then(res => res.json())
        .then(data => {
            $('#headerUserName').append(data.email);
            let roles = data.roles.map(r => " " + r.name.substring(5));
            $('#headerRole').append(roles);
            let user = `$(
                <tr>
                    <td>${data.id}</td>
                    <td>${data.firstName}</td>
                    <td>${data.lastName}</td>
                    <td>${data.age}</td>   
                    <td>${data.email}</td>
                    <td>${roles}</td>
                </tr>)`;
            $('#userTable').append(user);
        })
}