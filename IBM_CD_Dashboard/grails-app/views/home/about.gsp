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
                    <li><a href="http://ie.linkedin.com/in/smur89/">LinkedIn</a></li>
                    <li><a href="mailto:smur89@gmail.com?Subject=IBM%Project%20Contact">E-mail</a></li>
                </ul>
                </div>
            </div></section><!--end section-->
        <div class="lotusTips" role="note">
            <!-- header is an HTML5 element. Use div if you are using HTML4. -->
            <header class="lotusTipsHeader"><h3 class="lotusHeading">Tips</h3></header>

            <div class="lotusTipBody">
                <p>
                    This is my 4th Year Project, submitted for grading 30th April 2014.
                </p>
            </div></div><!--end tips-->

    </aside><!--end colRight-->
    <a id="lotusMainContent" name="lotusMainContent"></a>

    <div class="lotusContent" role="main">
        <div class="lotusAboutBox" role="region" aria-labelledby="aboutHeading">
            <img src="https://media.licdn.com/media/p/2/005/04d/14e/0e3809a.jpg" alt="">

            <div class="lotusAboutText">
                <header>
                    <!-- hgroup is an HTML5 element. Use div if you are using HTML4. -->
                    <hgroup>
                        <h1 id="aboutHeading" class="lotusHeading">CD Adoption Dashboard</h1>

                        <h3 class="lotusHeading2">A commit phase continuous delivery dashboard</h3>
                    </hgroup>
                </header>

                <p>
                    This application was created as part of an ongoing collaboration between <abbr
                        title="Institute of Technology, Tallaght">ITT</abbr>
                    and <abbr
                        title="International Business Machines">IBM</abbr>. Whereby students of ITT undertake a project on IBM's behalf. Students are
                reportable on a bi-weekly basis to IBM, and also directly to the IBM project coordinator, Dr. John Burns. The projects are developed
                using an Agile methodology and all technologies and approaches are decided by the students, however, technologies must be approved for
                use within IBM
                </p>
            </div><!-- end aboutText -->
        </div><!-- end aboutBox -->

        <div class="lotusContentColOne">
            <h1>Technology and Approahces</h1>

            <h2 class="lotusHeading">Groovy</h2>

            <p>
                Undertaking this project, I wanted to use a JVM based language to refresh my Java knowledge before entering the work environment
                where I knew I would most likely be working with Java. However, I didn't want to just use Java, I wanted to try something new.
                I had some limited experience of Groovy, and decided it would be worth considering. When I found Grails, my decision was made.
            </p>

            <p>
                Groovy allowed me to write dynamically compiled, statically typed code that would be converted to JVM bytecode. It also has many
                additional features over the current version of Java (Java 7), such as closures, which I used extensively when interacting with
                my Domain classes. Being able to write Java code side by side with groovy gave me extra flexibility where I couldn't find a
                groovy-like solution. It's simple handling of XML also appealed to me, as the project would be required to parse XML to traverse
                the RQM server to extract test results.
            </p>

            <p><a href="http://groovy.codehaus.org/" class="lotusAction">Find out more</a></p>

            <h2 class="lotusHeading">Grails</h2>

            <p>
                I stumbled across Grails (previously Groovy on Rails) while I was considering using Ruby on Rails for the project's implementation.
                It is an open source framework for the Groovy language using a 'Coding by Convention' paradigm. Sticking to these conventions
                would allow me to implement the projects quickly and handle some of the more repetitive or simple tasks, hiding much of the
                configuration details for high productivity development.
            </p>

            <p>
                It offers a consistent framework for development, using existing Java technologies like Spring and Hibernate. It uses SiteMesh
                templates for it's user GUI GSP (Groovy Server Pages) where one can embed tag libraries for creating web page components.
                I used a number of plugins in this particular application such as Google Visualisation, JQuery, Quartz2, Spring Security,
                Spring Security UI and others.
            </p>

            <p><a href="http://grails.org/" class="lotusAction">Find out more</a></p>
        </div><!--end contentColOne-->

        <div class="lotusContentColTwo">
            <h2 class="lotusHeading">Git</h2>

            <p>
                Git is a Source Control Management system. I chose to use a local repository using git to ensure all files were safe.
                This proved useful on a number of occasions when for unknown reasons, class files and folders went missing. It also
                roll back to a working copy of the application when I could not recover from changes I had made.
            </p>

            <p>
                Rather than choosing git for any of it's specific features, as I believe many <abbr
                    title="Source Code Management">SCM</abbr>
                would have suited my basic needs fine, I chose it as I was familiar with it already and seems to becoming the industry
                standard.
            </p>

            <p><a href="http://git-scm.com/" class="lotusAction">Find out more</a></p>

            <h2 class="lotusHeading">Agile Development</h2>

            <p>
                The basic principal behind Agile development methods is to develop iteratively and incrementally. We were expected to
                use an agile process by the college, but it also suited this project as features, requirements and scope changed throughout
                development. Developing in an agile enviroment allowed the project to adapt to these changes and stay on target for delivery.
            </p>

            <p>
                Agile development methods are guidelines, and can be adapted to on a case by case basis as required, and there are a number of
                Agile practices one can use, such as, Pair Programming, Refactoring, Scrum meetings and Test Driven Development.
            </p>

            <p><a href="http://agilemethodology.org/" class="lotusAction">Find out more</a></p>
        </div><!--end contentColTwo-->
    </div><!--end content-->
</div>

</body>
</html>