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
</head>

<body class="lotusui30_body lotusui30_fonts lotusui30">

<div class="lotusFrame lotusui30_layout">
    <!-- header is an HTML5 element. Remove header if you are using HTML4. -->
    <header role="banner">
        <div class="lotusBanner"><div class="lotusRightCorner"><div class="lotusInner">
            <a href="#lotusMainContent" accesskey="S" class="lotusAccess"><img src="../../css/images/blank.gif"
                                                                               alt="Skip to main content link. Accesskey S"/>
            </a><g:link controller="team" action="index" class="lotusLogo"><img alt="Product Name"
                                                                                src="../../css/images/blank.gif"/><span
                    class="lotusAltText">CD Adoption Dashboard</span></g:link>
            <ul class="lotusInlinelist lotusUtility"><li class="lotusFirst"><a role="button" aria-haspopup="true"
                                                                               href="javascript:;">Alex Kay <img
                        class="lotusArrow lotusDropDownSprite" src="../../css/images/blank.gif" alt=""
                        aria-label="Show menu"/><span class="lotusAltText">&#x25bc;</span></a></li><li><a
                    class="lotusBannerBtn" role="button" aria-haspopup="true" href="javascript:;">Share</a></li><li><a
                    role="button" aria-haspopup="true" aria-label="Email" href="javascript:;"><img
                        class="yourProductSprite yourProductSprite-iconPlaceholder16" src="../../css/images/blank.gif"
                        alt=""/><span class="lotusAltText">Email</span><span
                        class="lotusUnreadBadge lotusBadgeIcon"><img src="../../css/images/blank.gif" alt=""
                                                                     aria-label="New items"><span
                            class="lotusAltText">*</span></span> <img class="lotusArrow lotusDropDownSprite"
                                                                      src="../../css/images/blank.gif" alt=""
                                                                      aria-label="Show menu"/><span
                        class="lotusAltText">&#x25bc;</span></a></li><li><a role="button" aria-haspopup="true"
                                                                            aria-label="Calendar"
                                                                            href="javascript:;"><img
                        class="yourProductSprite yourProductSprite-iconPlaceholder16" src="../../css/images/blank.gif"
                        alt=""/><span class="lotusAltText">Calendar</span> <img class="lotusArrow lotusDropDownSprite"
                                                                                src="../../css/images/blank.gif" alt=""
                                                                                aria-label="Show menu"/><span
                        class="lotusAltText">&#x25bc;</span></a></li><li><a role="button" aria-haspopup="true"
                                                                            aria-label="Help" href="javascript:;"><img
                        class="yourProductSprite yourProductSprite-bannerHelp16" src="../../css/images/blank.gif"
                        alt=""/><span class="lotusAltText">Help</span></a></li><li><span class="lotusBranding"><img
                    src="../../css/images/blank.gif" alt="IBM" class="lotusIBMLogo"/><span
                    class="lotusAltText">IBM</span></span></li></ul>
            <!-- nav is an HTML5 element. Use div if you are using HTML4. -->
            <nav role="navigation" aria-label="[Product]">
                <ul class="lotusInlinelist lotusLinks" role="toolbar"><li class="lotusFirst lotusSelected"
                                                                          role="presentation"><a href="javascript:;"
                                                                                                 role="button"
                                                                                                 aria-pressed="true"><strong>Home</strong>
                    </a></li><li role="presentation"><a role="button" aria-haspopup="true"
                                                        href="javascript:;">People <img
                            class="lotusArrow lotusDropDownSprite" src="../../css/images/blank.gif" alt=""
                            aria-label="Show menu"/><span class="lotusAltText">&#x25bc;</span></a></li><li
                        role="presentation"><a role="button" aria-haspopup="true" href="javascript:;">Communities <img
                            class="lotusArrow lotusDropDownSprite" src="../../css/images/blank.gif" alt=""
                            aria-label="Show menu"/><span class="lotusAltText">&#x25bc;</span></a></li><li
                        role="presentation"><a role="button" aria-haspopup="true" href="javascript:;">Apps <img
                            class="lotusArrow lotusDropDownSprite" src="../../css/images/blank.gif" alt=""
                            aria-label="Show menu"/><span class="lotusAltText">&#x25bc;</span></a></li></ul>
            </nav>
        </div></div></div><!--end lotusBanner-->

        <div class="lotusTitleBar2"><div class="lotusWrapper"><div class="lotusInner">
            <div class="lotusTitleBarContent">
                <h2 class="lotusHeading"><img alt=""
                                              class="lotusIcon yourProductSprite yourProductSprite-iconPlaceholder24"
                                              src="../../css/images/blank.gif"><span
                        class="lotusText">${layoutTitle()}</span></h2>
            </div>

            <form class="lotusSearch" action="javascript:;" method="post" role="search">
                <table class="lotusLayout" cellspacing="0" role="presentation"><tr><td><a href="javascript:;"
                                                                                          id="searchScope"
                                                                                          class="lotusScope"
                                                                                          role="button"
                                                                                          aria-haspopup="true"
                                                                                          aria-label="Refine search scope"
                                                                                          title="Refine search scope"><img
                            class="lotusIcon yourProductSprite yourProductSprite-iconPlaceholder16"
                            src="../../css/images/blank.gif" alt="[Search scope]"/><span
                            class="lotusAltText">&#x25bc;</span></a></td><td><input id="lotusSearchtext"
                                                                                    name="lotusSearchtext"
                                                                                    class="lotusText lotusInactive"
                                                                                    type="text" value="Search"
                                                                                    title="Search"/></td><td><span
                        class="lotusBtnImg"><input class="lotusSearchButton" type="image" alt="Submit search"
                                                   title="Submit search" src="../../css/images/blank.gif"/><a
                            href="javascript:;" class="lotusAltText">Search</a></span></td></tr></table>
            </form>
        </div></div></div><!--end titleBar-->
        <div class="lotusTitleBarExt"><div class="lotusWrapper"><div class="lotusInner">
            <ul class="lotusInlinelist lotusRight lotusActions"><li class="lotusFirst"><a href="javascript:;"
                                                                                          role="button">Action</a>
            </li><li><a href="javascript:;" role="button">Action</a></li><li><a href="javascript:;" role="button"
                                                                                aria-haspopup="true">More Actions <img
                        class="lotusArrow lotusDropDownSprite" src="../../css/images/blank.gif" alt=""/><span
                        class="lotusAltText">&#x25bc;</span></a></li></ul>
        </div></div></div><!--end lotusTitleBarExt-->

    </header>

    <div class="lotusMain">
        <div class="lotusColLeft">
        </div><!--end colLeft-->

    <!-- aside is an HTML5 element. Use div if you are using HTML4. -->
        <aside class="lotusColRight">
        </aside><!--end colRight-->
        <a id="lotusMainContent" name="lotusMainContent"></a>

        <div class="lotusContent" role="main">
            <g:layoutBody/>



            <!-- Insert your content here -->

        </div><!--end content-->
    </div><!--end main-->
<!-- footer is an HTML5 element. Use div if you are using HTML4. -->
    <footer class="lotusFooter" role="contentinfo">
        <ul>
            <li><a href="javascript:;">Home</a></li>
            <li><a href="javascript:;">Demo</a></li>
            <li><a href="javascript:;">Help</a></li>
            <li><a href="javascript:;">Support Forums</a></li>
            <li><a href="javascript:;">Link</a></li>
            <li><a href="javascript:;">Link</a></li>
            <li><a href="javascript:;">About</a></li>
            <li><a href="javascript:;">[Application] on ibm.com</a></li>
            <li><a href="javascript:;">Submit Feedback</a></li>
        </ul>
    </footer><!--end footer-->

<!-- footer is an HTML5 element. Use div if you are using HTML4. -->
    <footer role="contentinfo">
        <table class="lotusLegal" cellspacing="0" role="presentation">
            <tr>
                <td><img class="lotusIBMLogoFooter" src="../../css/images/blank.gif" alt="IBM"/></td>
                <td class="lotusLicense">&copy; Copyright IBM Corporation &lt;2014&gt;.</td>
            </tr>
        </table>
    </footer>
</div><!--end frame-->

<!--popups go here-->

</body>
</html>
