IBM-CD-Dashboard
================

Continuous Delivery IBM Collaboration Services Adoption dashboard

Project Dashboard: https://trello.com/b/zX38z3EV/ibm-cd-dashboard

Background                                            
Continuous Delivery (CD) is a pattern language used in
software development to automate and improve the      
process of software delivery. Techniques such as      
automated testing, continuous integration and         
continuous deployment allow software to be developed

to a high standard and easily packaged and deployed to
test environments, resulting in the ability to        
rapidly, reliably and repeatedly push out enhancements
and bug fixes to customers at low risk and with       
minimal manual overhead.                              
                                                      
IBM Collaboration Solutions (ICS) have made the       
strategic decision to adopt Continuous Delivery       
Practices for all software development teams. Each ICS
Director is required to report progress on a set of CD
Transformation Checkpoints and Metrics to Executives  
on a regular and scheduled basis.                     
                                                      
ICS consists of a large range of software development 
teams, comprising OnPrem, Cloud and Mobile.           
                                                      
CD Transformation Checkpoints and Metrics             
                                                      
The following are the key measurable CD Transformation
Checkpoints and Metrics                               
                                                      
                                                      
                                                      
Transformation Checkpoint                                    
                                                      
                           Each code submission       
                           triggers the pipeline in   
                           serial                     
                                                      
                                                      
                           Jenkins provides CI        
                           pipeline                   
                                                      
                                                      
                           CI pipeline is fully       
                           automated                  
                                                      
                                                      
                           Single source              
                           repository/trunk           
                                                      
                                                      
                           All artifacts kept in      
                           version control            
                                                      
                                                      
                           All Commit Phase failures  
                           stop the pipeline          
                                                      
                                                      
                           SPRs add data to track test
                           escapes                    
                                                      
CI pipeline is implemented         
                   
                           Leverage common metrics    
                           repository and dashboard   
                                                      
                                                      
                           Push-button automated      
                           pre-submission validation  
                                                      
                                                      
                           All new code is code       
                           reviewed                   
                                                      
                                                      
                           All new code has unit and  
                           functional test coverage   
                                                      
                                                      
                           Automated tests added for  
                           all resolved SPRs          
                                                      
Developer role and enablement   
                      
                           SPRs created for all issues
                           outside of the Commit Phase
                                                      
                                                      
                           All test deployments use   
                           production deployment      
                           processes and are fully    
                           automated/repeatable       
                                                      
                                                      
                           All test deployments use   
                           production-congruent       
                           environments/stacks        
                                                      
                                                      
                           Full                       
                           regression/compatibility   
                           testing of APIs and        
                           extensions                 
                                                      
                                                      
                           Simian Army testing occurs 
                           continuously               
                                                      
                                                      
                           Dashboard metrics gathering
                           is automated               
                                                      
                                                      
                           Continuous on-premises     
                           testing (NFR and on-prem   
                           only features)             
                                                      
                                                      
                           Zero downtime updates      
                                                      
Continuous delivery          
                         
                           Additional SCSB            
                           usage/defect metrics stored
                           in repository              
                                                      
                                                      
CD Transformation Metrics                             
                                                      
	Phase				   Metric						Measurement Value                         
                           
Commit Phase                
                          
                           Build Duration 				Minutes            
                                                      
                           Manual testing duration    
                           (automatable) 				Person Weeks      
                            
Acceptance Test Phase       
                          
                           API Test Coverage (via     
                           automated measurement) 		% Value            
Manual Test Phase         
                            
                           Manual testing duration    
                           (non-automatable) 			Person Weeks       
                                                      
                           Time from final code       
                           submission to production     Days
                           (Cloud) 						               
                                                      
                           Time from final code       
                           submission to GA             Days
                           (On-Premises)              
                                                  
                                                      
                           SPRs opened per capita     
                           (general quality measure)    Number
                                                
CD Business Value           
                          
                           Cumulative open+deferred   
                           defects (technical debt)     Number
                                                
                                                      
                                                      
Project                                               
Develop an Continuous Delivery ICS Adoption Dashboard 
which reports out each CD Transformation and Metric as
defined above on a per software product development   
team basis using real and verifiable data.            
                                                      
The data must be fed in from verifiable sources to    
ensure confidence in the status presented by the      
dashboard.  It cannot be a tick box exercise.         
                                                      
For the purposes of the project, research can be      
carried out on the source and format of the data feed 
and how that data is presented to the dashboard.      
Sample data can be used.                              
                                                      
The dashboard must be extensible to include additional
metrics once known.                                   
                                                      
The dashboard must be capable of being easily merged  
with any future common metrics repository and         
dashboard.                                            
                                                      
Benefits                                              
The main purpose of the dashboard is to provide       
information to team members, management and executives
on how they are doing against defined goals.          
                                                      
This data is used in different ways depending on the  
role of the individual viewing the data i.e. Team     
Member, Team Manager, Executive, Vice President,      
Chairperson                                           
