/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const dropdowns = document.querySelectorAll('.dropdownProfile');

dropdowns.forEach(dropdownProfile  => {
        const select = dropdownProfile.querySelector('.select');
        const caret = dropdownProfile.querySelector('.caret');
        const menu = dropdownProfile.querySelector('.menu');
        const options = dropdownProfile.querySelectorAll('.menu li');
        const selected = dropdownProfile.querySelector('.selected');

        select.addEventListener('click', ()=>{
            select.classList.toggle('select-clicked');

            caret.classList.toggle('caret-rotate');

            menu.classList.toggle('menu-open');

        });

        options.forEach(options=>{
            options.addEventListener('click',() =>{
                selected.innerText = option.innerText;

                select.classList.remove('select-clicked');

                caret.classList.remove('.caret-rotate');

                menu.classList.remove('.menu-open');

                options.forEach(option => {
                    option.classList.remove('.active');
                });

                option.classList.remove('.active');
            });
        });

})

