<!DOCTYPE html>
<html lang="en-US">
<head>
    <!--
Licensed Materials - Property of IBM.
(c) Copyright IBM Corporation 2001, 2012.  All Rights Reserved.
U.S. Government Users Restricted Rights:  Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
-->
    <meta charset="UTF-8" />
    <title><g:if env="development">Grails Runtime Exception</g:if><g:else>Error</g:else></title>
    <meta name="Description" content="Example error page"/>
    <!--[if IE 6]><![endif]--><!--fixes IE8 performance issue of conditional comments blocking css download-->


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

</head>
<body class="lotusui30_body lotusui30_fonts lotusui30 lotusError">

<div class="lotusui30_layout">
    <div class="lotusErrorBox">
        <div class="lotusErrorContent" role="main">
            <img class="lotusIcon yourProductSprite yourProductSprite-msgError48" src="../../css/images/blank.gif" alt="Error" />
            <div class="lotusErrorForm">
                <h1 class="lotusHeading">We are unable to process your request</h1>
                <g:if env="development">
                    <g:renderException exception="${exception}" />
                </g:if>
                <g:else>
                    <ul class="errors">
                        <li>An error has occurred</li>
                    </ul>
                </g:else>
                <p>Click the browser back button to return to the previous page and try again.  If this error persists, report the problem to your administrator.</p>
                    <div class="lotusBtnContainer"><g:link controller="team" action="index" class = "lotusBtn" >Return to Application</g:link><span><a href="mailto:X00085315@ittd.ie?subject=Error%20${exception.getCause()}%20body=${exception.getStackTraceText()}">Report this Problem</a></span></div>
            </div><!-- end errorForm -->
        </div>
        <!-- end errorContent -->
    </div><!-- end errorBox -->
</div><!--end error-->

</body>
</html>