$(document).ready(function() {
    function renderDepartment(department, container) {
        const departmentElement = $('<div>').addClass('department');
        const departmentName = $('<span>').text(department.name).css('font-weight', 'bold');
        departmentElement.append(departmentName);

        // Employee list, initially hidden
        const employeeList = $('<ul>').addClass('hidden');
        department.employees.forEach(emp => {
            employeeList.append($('<li>').text(emp.name));
        });
        departmentElement.append(employeeList);

        // Toggle employee list on department name click
        departmentName.on('click', function(event) {
            employeeList.toggleClass('hidden');
            event.stopPropagation(); // Prevent this click from triggering sub-department toggles
        });

        // Sub-departments
        if (department.subDepartments && department.subDepartments.length > 0) {
            const subDeptContainer = $('<div>').addClass('sub-departments hidden');
            department.subDepartments.forEach(subDept => {
                renderDepartment(subDept, subDeptContainer);
            });
            departmentElement.append(subDeptContainer);

            departmentName.on('click', function() {
                subDeptContainer.toggle();
                event.stopPropagation(); // Prevent this click from triggering employee list toggles
            });
        }

        container.append(departmentElement);
    }

    function fetchAndDisplayDepartments() {
        $.ajax({
            url: '/api/departments',
            method: 'GET',
            success: function(departments) {
                const container = $('#departmentsContainer');
                departments.forEach(dept => {
                    renderDepartment(dept, container);
                });
            },
            error: function() {
                alert('Failed to load departments. Please try again.');
            }
        });
    }

    fetchAndDisplayDepartments();
});
