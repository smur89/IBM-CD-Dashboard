<%--
  Created by IntelliJ IDEA.
  User: shanemurphy
  Date: 01/04/2014
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>About</title>
</head>
<body>

<div class="lotusMain">

    <!-- aside is an HTML5 element. Use div if you are using HTML4. -->
    <aside class="lotusColRight">
        <!-- section is an HTML5 element. Use div if you are using HTML4. -->
        <section class="lotusSection2 lotusFirst">
            <!-- header is an HTML5 element. Use div if you are using HTML4. -->
            <header class="lotusSectionHeader">
                <h2 class="lotusHeading lotusFirst">Find Out More...</h2>
            </header>
            <div id="[sectionBodyID]" class="lotusSectionBody">
                <div class="lotusChunk"><ul class="lotusList">
                    <li><a href="javascript:;">Help</a></li>
                    <li><a href="javascript:;">Frequently asked questions</a></li>
                    <li><a href="javascript:;">Other networking tools from IBM</a></li>
                </ul>
                </div>
            </div></section><!--end section-->
        <div class="lotusTips" role="note">
            <!-- header is an HTML5 element. Use div if you are using HTML4. -->
            <header class="lotusTipsHeader"><h3 class="lotusHeading">Tips</h3><span class="lotusClose" title="Close tip"><input type="image" alt="Close tip" src="../../css/images/blank.gif"><a href="javascript:;" class="lotusAltText">X</a></span></header>
            <div class="lotusTipBody">
                <p>This is a tip.  It sits on a page to give the user some helpful information.  It has an optional close button to permanently dismiss it.</p>
            </div></div><!--end tips-->

    </aside><!--end colRight-->
    <a id="lotusMainContent" name="lotusMainContent"></a>
    <div class="lotusContent" role="main">
        <div class="lotusAboutBox" role="region" aria-labelledby="aboutHeading">
            <img src="../../docResources/devdocImages/GenericApp128.png" alt="">
            <div class="lotusAboutText">
                <header>
                    <!-- hgroup is an HTML5 element. Use div if you are using HTML4. -->
                    <hgroup>
                        <h1 id="aboutHeading" class="lotusHeading">Application Name</h1>
                        <h3 class="lotusHeading2">Marketing tagline goes here</h3>
                    </hgroup>
                </header>
                <p>This is a callout box. Detailed <a href="javascript:;">marketing information</a> goes here. Ut caecus quis enim in ea consequat antehabeo, probo, quidem, loquor, uxor, et ea. Nutus autem ut <a href="javascript:;">vulputate obruo</a>, facilisi at feugait aliquam quod quibus tristique hos eros nibh.</p>
            </div><!-- end aboutText -->
        </div><!-- end aboutBox -->

        <div class="lotusContentColOne">
            <h2 class="lotusHeading">Fatua quidem roto, velit si, gilvus erat cogo</h2>
            <p>Eu lenis blandit. Abbas nulla, delenit, dolus diam ille. Si nulla autem ea tristique, blandit adsum nulla in secundum obruo vel abluo. Vulputate vereor iriure facilisi at, aliquip nulla vulputate venio saepius suscipit genitus virtus ex duis. </p>
            <p><a href="javascript:;" class="lotusAction">Find out more</a></p>
            <h2 class="lotusHeading">Tego tamen decet</h2>
            <p>Vulputate vereor iriure facilisi at, aliquip nulla vulputate venio saepius suscipit genitus virtus ex duis.</p>
            <p><a href="javascript:;" class="lotusAction">Find out more</a></p>
        </div><!--end contentColOne-->

        <div class="lotusContentColTwo">
            <h2 class="lotusHeading">Si nulla autem ea tristique!</h2>
            <p>Fatua quidem roto, velit si, gilvus erat cogo. Si nulla autem ea tristique, blandit adsum nulla in secundum obruo vel abluo. Vulputate vereor iriure facilisi at, aliquip nulla vulputate venio saepius suscipit genitus virtus ex duis. Tego tamen decet iusto secundum ea genitus, fatua probo eum, eu lenis blandit. Abbas nulla, delenit, dolus diam ille.</p>
            <p><a href="javascript:;" class="lotusAction">Find out more</a></p>
            <h2 class="lotusHeading">Vulputate venio saepius suscipit genitus</h2>
            <p>Si nulla autem ea tristique, blandit adsum nulla in secundum obruo vel abluo. Vulputate vereor iriure facilisi at, aliquip nulla vulputate venio saepius suscipit genitus virtus ex duis. Tego tamen decet iusto secundum ea genitus, fatua probo eum, eu lenis blandit. Abbas nulla, delenit, dolus diam ille.</p>
            <p><a href="javascript:;" class="lotusAction">Find out more</a></p>
        </div><!--end contentColTwo-->
    </div><!--end content-->
</div>

</body>
</html>