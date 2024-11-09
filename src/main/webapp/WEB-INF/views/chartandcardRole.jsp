<!-- Content Area -->
<div class="content">
    <div class="container">
        <h2>Roles Statistics</h2>

        <!-- Cards Section -->
        <div class="row">
            <!-- Total Users Card (Primary) -->
            <div class="col-md-3">
                <div class="card text-white bg-primary mb-3">
                    <div class="card-header">Total Roles</div>
                    <div class="card-body">
                        <h5 class="card-title">1,234</h5> <!-- Replace with dynamic count -->
                        <p class="card-text">Total registered roles created on the platform.</p>
                    </div>
                </div>
            </div>

            <!-- Pending Approvals Card (Warning) -->
            <div class="col-md-3">
                <div class="card text-white bg-warning mb-3">
                    <div class="card-header">Pending Approvals</div>
                    <div class="card-body">
                        <h5 class="card-title">56</h5> <!-- Replace with dynamic count -->
                        <p class="card-text">Roles awaiting to be approved.</p>
                    </div>
                </div>
            </div>

            <!-- Successful Logins Card (Success) -->
            <div class="col-md-3">
                <div class="card text-white bg-success mb-3">
                    <div class="card-header">Roles assigned</div>
                    <div class="card-body">
                        <h5 class="card-title">987</h5> <!-- Replace with dynamic count -->
                        <p class="card-text">Successful users with roles.</p>
                    </div>
                </div>
            </div>

            <!-- Account Issues Card (Danger) -->
            <div class="col-md-3">
                <div class="card text-white bg-danger mb-3">
                    <div class="card-header">Roles Issues</div>
                    <div class="card-body">
                        <h5 class="card-title">23</h5> <!-- Replace with dynamic count -->
                        <p class="card-text">Users with account-related issues.</p>
                    </div>
                </div>
            </div>
        </div>

        <!-- Chart Examples -->
        <div class="row">
            <div class="col-md-6 chart-container">
                <h4>Bar Chart Roles</h4>
                <canvas id="barChart"></canvas>
            </div>
            <div class="col-md-6 chart-container">
                <h4>Area Chart Roles</h4>
                <canvas id="areaChart"></canvas>
            </div>
        </div>