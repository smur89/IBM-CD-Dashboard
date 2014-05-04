<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Help Page</title>
</head>

<body>

<h1>User Manual</h1>

<h2>Installation</h2>

<p>The application is packaged in a  Web Application Archive File (WAR) which can be deployed on any Java EE compliant application server. This WAR file can be found in the IBM_CD_DASHBOARD/target Directory. It is entitled IBM_CD_Dashboard-0.1.war.
</p>

<p>The application requires a MySQL database titled ‘ibm’ to be running on the local machine on port 8889. The full URL for this should be the following format: localhost:8889/ibm or 127.0.0.1/ibm.
</p>

<p>To utilise the RTC functionality of the project, it is expected that the RTC Server also be running locally on port 9443. The project only uses the RTC section of the server and so the full URL for this should be the following format: localhost:9443/ccm or 127.0.0.1/ccm.
</p>

<p>Once deployed the application initializes itself, pulling in all available data and creating two default users.
</p>
<table>
    <tr><th></th><th>Username</th><th>Password</th><th>Role</th></tr>
    <tr><td>1</td><td>user</td><td>password</td><td>User</td></tr>
    <tr><td>2</td><td>admin</td><td>password</td><td>Admin</td></tr>
</table>


<h2>Application Manual</h2>
<ol>
    <h3>Home Screen</h3>

    <g:img dir="/images/Help" file="Home.png" width="1200" height="600" />


    <li>Refresh</li>

    <p>This button causes the current page to refresh. It is dislayed on every page in the application.</p>
    <li>Login</li>

    <p>This redirects the user to the login page where they can supply their log in information in order to customize their views.
    <li>Help</li>

    <p>A Link to any help information available to the user.</p>
    <li>Summary Statistics</li>

    <p>Each Team or Project has it’s own area in which to display summary statistics.  The area is defined by a small border around the area, to distinguish between builds.
    </p>   <li>Defects</li>

    <p>Defects are broken down into 3 severity groups, as defined by IBM. S1, S2 and S3. These are broken down into a pie chart to give an idea of the overall percentage of each defect group.
    </p><li>Build Times</li>

    <p>Build times are displayed in a graph representing the times per build commit over time. The most recent commit is the right most build time information.
    </p><li>Test Times</li>

    <p>Test times are displayed in a graph representing the times per Test commit over time. The most recent commit is the right most build’s time information.
    </p><li>Additional Metrics</li>

    <p>Any additional pertinent information is displayed here where it is not appropriate to display it in a graphical image.</p>

    <h3>Home Screen Logged In</h3>
    <g:img dir="/images/Help" file="HomeLoggedIn.png" width="1200" height="600" />


    <li>Logout</li>

    <p>Link signs the user out from the application</p>
    <li>User Profile</li>

    <p>Link to edit the current users profile</p>

    <h3>Login</h3>
    <g:img dir="/images/Help" file="Login.png" width="1200" height="600" />


    <li>Username Field</li>

    <p>User enters their username here.</p>
    <li>Password Field</li>

    <p>User enters their password here.</p>
    <li>Login Submit</li>

    <p>Submit the entered username and password for verification.</p>
    <li>Remember Me</li>

    <p>Persists the session cookie for this user past the default, which is the lifetime of the browser.</p>

    <h3>Team Info</h3>
    <g:img dir="/images/Help" file="TeamInfo.png" width="1200" height="600" />


    <li>Build Time Graph</li>

    <p>Build times are displayed in a graph representing the times per build commit over time. The most recent commit is the right most build time information.
    </p>
    <li>Build Summary Statistics</li>

    <p>Any additional pertinent information is displayed here where it is not appropriate to display it in a graphical image
    </p>

    <li>Team Member Information</li>

    <p>Team members and their contact email address are displayed here. Each email address is a mailto link.</p>
    <li>Individual Builds</li>

    <p>Each  build and some high level information about them are displayed here. Clicking on the build will allow you to view the build in higher granularity.
    </p>
    <h3>Team Info No Data </h3>

    <g:img dir="/images/Help" file="TeamInfoNoData.png" width="1200" height="600" />


    <li>No Data</li>

    <p>If no Build information is present for the current project, the summary page will display as above.</p>

    <h3>Build Info</h3>

    <g:img dir="/images/Help" file="BuildInfo.png" width="1200" height="600" />


    <li>Build Information</li>

    <p>Information specific to this build is displayed here.</p>
    <li>Individual Work Items</li>

    <p>Builds are comprised of Work Items, these are displayed here and can be viewed in more detail by clicking on them.</p>

    <h3>WorkItem Info</h3>

    <li>WorkItem Information</li>

    <p>Work Item information about this particular work item is displayed here</p>

    <h3>About</h3>

    <g:img dir="/images/Help" file="About.png" width="1200" height="600" />


    <li>Project Overview</li>

    <p>This page gives a brief overview of how the project was implemented.</p>
    <li>Contact Information</li>

    <p>Information on how to contact the developer is displayed here.</p>

    <h3>User Profile Edit</h3>

    <g:img dir="/images/Help" file="UserProfileCheckBoxes.png" width="1200" height="600" />


    <li>Check Boxes</li>

    <p>Selecting or deselecting these checkboxes subscribe or unsubscribe from projects.</p>

    <h3>User Profile</h3>
    <g:img dir="/images/Help" file="UserProfile.png" width="1200" height="600" />


    <li>Project List</li>

    <p>A List of the current users subscribed projects are displayed here.</
    p>

    <h3>Footer</h3>

    <g:img dir="/images/Help" file="Footer.png" width="1200" height="100" />


    <li>Home</li>

    <p>Redirects to the IBM home page.</p>
    <li>Help</li>

    <p>Redirects to the help page for the application.</p>
    <li>About</li>

    <p>Redirects to the about page.</p>
    <li>Submit Feedback</li>

    <p>Mailto link to email feedback.</p>
</ol>

</body>
</html>