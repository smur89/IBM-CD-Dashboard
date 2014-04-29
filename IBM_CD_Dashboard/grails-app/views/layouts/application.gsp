<%@ page import="ibm_cd_dashboard.User" %>
<!DOCTYPE html>
<html lang="en-US">
<head>

    <meta charset="UTF-8"/>
    <title><g:layoutTitle default="IBM CD Adoption Dashboard"/></title>
    <meta name="Description" content="Continuous Delivery Adoption Dashboard"/>
    <!--[if IE 6]><![endif]--><!--fixes IE8 performance issue of conditional comments blocking css download-->

    %{--<r:require module='common'/>--}%

    <link rel="stylesheet" href="${resource(dir: 'css/base', file: 'core.css')}" type="text/css"/>
    <link rel="stylesheet" href="${resource(dir: 'css/defaultTheme', file: 'defaultTheme.css')}" type="text/css"/>


    <!--
	The following conditional logic is needed to add in the IE specific classes.
	If you really wanted to do this on the server with browser sniffing, you could do that too,
	but that would not be the way Microsoft recommends doing it.
    -->
    <!--[if IE 6]>
<script>
	document.getElementsByTagName("html")[0].className+=" lotusui_ie lotusui_ie6";
</script>
<![endif]-->
    <!--[if IE 7]>
<script>
	document.getElementsByTagName("html")[0].className+=" lotusui_ie lotusui_ie7";
</script>
<![endif]-->
    <!--[if IE 8]>
<script>
	document.getElementsByTagName("html")[0].className+=" lotusui_ie8";
</script>
<![endif]-->
    <!--[if IE 9]>
<script>
	document.getElementsByTagName("html")[0].className+=" lotusui_ie9";
</script>
<![endif]-->
    <!--[if IE]>
<script>
	document.createElement('article');
	document.createElement('aside');
	document.createElement('footer');
	document.createElement('header');
	document.createElement('hgroup');
	document.createElement('nav');
	document.createElement('section');
</script>
<![endif]-->
    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body class="lotusui30_body lotusui30_fonts lotusui30">

<div class="lotusFrame lotusui30_layout">
    <!-- header is an HTML5 element. Remove header if you are using HTML4. -->
    <header role="banner">
        <div class="lotusBanner"><div class="lotusRightCorner"><div class="lotusInner">
            <a href="#lotusMainContent" accesskey="S" class="lotusAccess">
                <g:img dir="css/images" file="blank.gif" alt="Skip to main content link. Accesskey S"/>
            </a><g:link controller="team" action="index" class="lotusLogo">
                <g:img dir="css/images" file="blank.gif" alt="Product Name"/><span
                        class="lotusAltText">CD Adoption Dashboard</span></g:link>
            <ul class="lotusInlinelist lotusUtility">
                <sec:ifNotLoggedIn>
                    <li>
                        <g:link controller="login">Login</g:link>
                    </li>
                </sec:ifNotLoggedIn>
                <sec:ifLoggedIn>
                    <li>
                        <g:link controller="logout" role="button" class="lotusBannerBtn">Logout</g:link>
                    </li>
                    <li>
                        <g:link controller="userProfile" action="show" role="button"
                                class="lotusBannerBtn">User Profile</g:link>
                    </li>
                </sec:ifLoggedIn>
                <li>
                    <g:link controller="Home" action="help" class="yourProductSprite yourProductSprite-bannerHelp16">
                        <g:img dir="css/images" file="help.gif"
                               class="yourProductSprite yourProductSprite-bannerHelp16"/>
                    </g:link>
                </li>
                <li>
                    <span class="lotusBranding">
                        <g:img dir="/css/images" file="blank.gif" alt="IBM" class="lotusIBMLogo"/>
                        <span class="lotusAltText">IBM</span>
                    </span>
                </li>
            </ul>
            <!-- nav is an HTML5 element. Use div if you are using HTML4. -->
            <nav role="navigation" aria-label="[Product]">
                <ul class="lotusInlinelist lotusLinks" role="toolbar">
                    <li class="lotusFirst" role="presentation">
                        <a onclick="window.location.reload();" role="button" aria-pressed="true">
                            <g:img dir="css/images" file="refresh_graphic.png" class="lotusIcon"/>
                        </a>
                    </li>
                </ul>
            </nav>
        </div></div></div><!--end lotusBanner-->

        <div class="lotusTitleBar2"><div class="lotusWrapper"><div class="lotusInner">
            <div class="lotusTitleBarContent">
                <h2 class="lotusHeading">
                    <g:img dir="/css/images" file="blank.gif"
                           class="lotusIcon yourProductSprite yourProductSprite-iconPlaceholder24"/>
                    <span class="lotusText">${layoutTitle()}</span></h2>
            </div>

        </div>
        </div>
        </div><!--end titleBar-->

    </header>

    <div class="lotusMain">

        <div class="lotusContent" role="main">

            <g:layoutBody/>

        </div><!--end content-->
        <span aria-hidden="true" class="lotusRight"><g:img dir="/css/images" file="blank.gif" alt="IBM"
                                                           class="lotusIBMLogo"/><span class="lotusAltText">IBM</span>
        </span>

    </div><!--end main-->


<!-- footer is an HTML5 element. Use div if you are using HTML4. -->
    <footer class="lotusFooter" role="contentinfo">
        <ul>
            <li><a href="http://ibm.com">Home</a></li>
            <li><g:link controller="Home" action="help">Help</g:link></li>
            <li><g:link controller="Home" action="about">About</g:link></li>
            <li><a href="mailto:feedback@ibm.com?Subject=CD%20Dashboard%20Feedback">Submit Feedback</a></li>
        </ul>
    </footer><!--end footer-->

<!-- footer is an HTML5 element. Use div if you are using HTML4. -->
    <footer role="contentinfo">
        <table class="lotusLegal" cellspacing="0" role="presentation">
            <tr>
                <td><g:img dir="/css/images" file="blank.gif" alt="IBM" class="lotusIBMLogoFooter"/></td>
                <td class="lotusLicense">&copy; Copyright IBM Corporation 2014.</td>
            </tr>
        </table>
    </footer>
</div><!--end frame-->

<!--popups go here-->
<r:layoutResources/>
</body>
</html>
