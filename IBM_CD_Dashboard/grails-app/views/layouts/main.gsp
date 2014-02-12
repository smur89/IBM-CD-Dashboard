<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    %{-- IBM CSS Files--}%
    <link rel="stylesheet" href="${resource(dir: 'css/base', file: 'core.css')}" type="text/css"/>
    <link rel="stylesheet" href="${resource(dir: 'css/defaultTheme', file: 'defaultTheme.css')}" type="text/css"/>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
    <link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
    <link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">


    %{-- The following conditional logic is needed to add in the IE specific classes. --}%
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

<body>
<div class="lotusFrame lotusui30_layout">
    <!-- header is an HTML5 element. Remove header if you are using HTML4. -->
    <header role="banner">
        <div class="lotusBanner"><div class="lotusRightCorner"><div class="lotusInner">
            <a href="#lotusMainContent" accesskey="S" class="lotusAccess"><img
                    src="${resource(dir: 'images', file: 'blank.gif')}" alt="Skip to main content link. Accesskey S"/>
            </a><a class="lotusLogo" href="javascript:;"><img alt="Product Name"
                                                              src="${resource(dir: 'images', file: 'blank.gif')}"/><span
                    class="lotusAltText">Product Name</span></a>
            <ul class="lotusInlinelist lotusUtility"><li class="lotusFirst"><a role="button" aria-haspopup="true"
                                                                               href="javascript:;">Alex Kay <img
                        class="lotusArrow lotusDropDownSprite" src="${resource(dir: 'images', file: 'blank.gif')}"
                        alt="" aria-label="Show menu"/><span class="lotusAltText">&#x25bc;</span></a></li><li><a
                    class="lotusBannerBtn" role="button" aria-haspopup="true" href="javascript:;">Share</a></li><li><a
                    role="button" aria-haspopup="true" aria-label="Email" href="javascript:;"><img
                        class="yourProductSprite yourProductSprite-iconPlaceholder16"
                        src="${resource(dir: 'images', file: 'blank.gif')}" alt=""/><span
                        class="lotusAltText">Email</span><span class="lotusUnreadBadge lotusBadgeIcon"><img
                        src="${resource(dir: 'images', file: 'blank.gif')}" alt="" aria-label="New items"><span
                        class="lotusAltText">*</span></span> <img class="lotusArrow lotusDropDownSprite"
                                                                  src="${resource(dir: 'images', file: 'blank.gif')}"
                                                                  alt="" aria-label="Show menu"/><span
                        class="lotusAltText">&#x25bc;</span></a></li><li><a role="button" aria-haspopup="true"
                                                                            aria-label="Calendar"
                                                                            href="javascript:;"><img
                        class="yourProductSprite yourProductSprite-iconPlaceholder16"
                        src="${resource(dir: 'images', file: 'blank.gif')}" alt=""/><span
                        class="lotusAltText">Calendar</span> <img class="lotusArrow lotusDropDownSprite"
                                                                  src="${resource(dir: 'images', file: 'blank.gif')}"
                                                                  alt="" aria-label="Show menu"/><span
                        class="lotusAltText">&#x25bc;</span></a></li><li><a role="button" aria-haspopup="true"
                                                                            aria-label="Help" href="javascript:;"><img
                        class="yourProductSprite yourProductSprite-bannerHelp16"
                        src="${resource(dir: 'images', file: 'blank.gif')}" alt=""/><span
                        class="lotusAltText">Help</span></a></li><li><span class="lotusBranding"><img
                    src="${resource(dir: 'images', file: 'blank.gif')}" alt="IBM" class="lotusIBMLogo"/><span
                    class="lotusAltText">IBM</span></span></li></ul>
            <!-- nav is an HTML5 element. Use div if you are using HTML4. -->
            <nav role="navigation" aria-label="[Product]">
                <ul class="lotusInlinelist lotusLinks" role="toolbar"><li class="lotusFirst lotusSelected"
                                                                          role="presentation"><a href="javascript:;"
                                                                                                 role="button"
                                                                                                 aria-pressed="true"><strong>Home</strong>
                    </a></li><li role="presentation"><a role="button" aria-haspopup="true"
                                                        href="javascript:;">People <img
                            class="lotusArrow lotusDropDownSprite" src="${resource(dir: 'images', file: 'blank.gif')}"
                            alt="" aria-label="Show menu"/><span class="lotusAltText">&#x25bc;</span></a></li><li
                        role="presentation"><a role="button" aria-haspopup="true" href="javascript:;">Communities <img
                            class="lotusArrow lotusDropDownSprite" src="${resource(dir: 'images', file: 'blank.gif')}"
                            alt="" aria-label="Show menu"/><span class="lotusAltText">&#x25bc;</span></a></li><li
                        role="presentation"><a role="button" aria-haspopup="true" href="javascript:;">Apps <img
                            class="lotusArrow lotusDropDownSprite" src="${resource(dir: 'images', file: 'blank.gif')}"
                            alt="" aria-label="Show menu"/><span class="lotusAltText">&#x25bc;</span></a></li></ul>
            </nav>
        </div></div></div><!--end lotusBanner-->

        <div class="lotusTitleBar2"><div class="lotusWrapper"><div class="lotusInner">
            <div class="lotusTitleBarContent">
                <h2 class="lotusHeading"><img alt=""
                                              class="lotusIcon yourProductSprite yourProductSprite-iconPlaceholder24"
                                              src="${resource(dir: 'images', file: 'blank.gif')}"><span
                        class="lotusText">Application Name</span></h2>
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
                            src="${resource(dir: 'images', file: 'blank.gif')}" alt="[Search scope]"/><span
                            class="lotusAltText">&#x25bc;</span></a></td><td><input id="lotusSearchtext"
                                                                                    name="lotusSearchtext"
                                                                                    class="lotusText lotusInactive"
                                                                                    type="text" value="Search"
                                                                                    title="Search"/></td><td><span
                        class="lotusBtnImg"><input class="lotusSearchButton" type="image" alt="Submit search"
                                                   title="Submit search"
                                                   src="${resource(dir: 'images', file: 'blank.gif')}"/><a
                            href="javascript:;" class="lotusAltText">Search</a></span></td></tr></table>
            </form>
        </div></div></div><!--end titleBar-->
        <div class="lotusTitleBarExt"><div class="lotusWrapper"><div class="lotusInner">
            <ul class="lotusInlinelist lotusRight lotusActions"><li class="lotusFirst"><a href="javascript:;"
                                                                                          role="button">Action</a>
            </li><li><a href="javascript:;" role="button">Action</a></li><li><a href="javascript:;" role="button"
                                                                                aria-haspopup="true">More Actions <img
                        class="lotusArrow lotusDropDownSprite" src="${resource(dir: 'images', file: 'blank.gif')}"
                        alt=""/><span class="lotusAltText">&#x25bc;</span></a></li></ul>
        </div></div></div><!--end lotusTitleBarExt-->



        <div id="grailsLogo" role="banner"><a href="http://grails.org"><img
                src="${resource(dir: 'images', file: 'grails_logo.png')}" alt="Grails"/></a></div>
        <g:layoutBody/>
        <div class="footer" role="contentinfo"></div>
        %{--<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>--}%
        <g:javascript library="application"/>
        <r:layoutResources/>
</body>
</html>
