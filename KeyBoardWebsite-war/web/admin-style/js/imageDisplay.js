/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


 function choosefile(fileInput){
            if(fileInput.files && fileInput.files[0]){
                var reander = new FileReader();
                reander.onload = function (e) {
                    $('#image').attr('src' ,e.target.result); 
                }
                
                reander.readAsDataURL(fileInput.files[0]);
            }
        }