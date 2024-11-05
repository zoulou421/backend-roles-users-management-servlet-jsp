<!-- Right-Aligned Menu Component with Search Bar, Submenu, and User Display -->
<div class="menu-bar d-flex align-items-center justify-content-end p-3">
    <!-- Right side: User Info, Search Bar, and Submenu -->
    <div class="d-flex align-items-center">
        <!-- User Info -->
        <div class="user-info text-white me-3">
            <i class="fas fa-user-circle me-2"></i>
            <span>Welcome, <strong>User Name</strong></span> <!-- Replace "User Name" dynamically -->
        </div>

        <!-- Search Bar -->
        <div class="search-bar me-3">
            <input type="text" placeholder="Search..." class="form-control d-inline w-auto" />
            <button class="btn btn-light"><i class="fas fa-search"></i></button>
        </div>

        <!-- Submenu Dropdown -->
        <div class="dropdown">
            <button class="btn btn-dark dropdown-toggle" type="button" id="settingsDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fas fa-cog"></i>
            </button>
            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="settingsDropdown">
                <li><a class="dropdown-item" href="#">Settings</a></li>
                <li><a class="dropdown-item" href="#">Logout</a></li>
            </ul>
        </div>
    </div>
</div>


<style>
.menu-bar {
    background-color: black; /* Dark gray background */
    color: white;
    width:100%;
}

.menu-bar .user-info {
    font-size: 1.1em;
}

.menu-bar .search-bar {
    display: flex;
    align-items: center;
}

.menu-bar .search-bar input {
    border: none;
    padding: 5px;
    margin-right: 5px;
    border-radius: 4px;
}

.menu-bar .search-bar button {
    border: none;
    background: none;
    color: #343a40;
}

.menu-bar .dropdown-toggle {
    background: none;
    border: none;
    color: white;
}

.menu-bar .dropdown-menu {
    min-width: 160px;
}

</style>