package Week10LAB;

/*
First - @CanSendMessage -> METHODS (Grant users to ability to send messages)
Second - @RequiresPermission -> CLASSES/METHODS (Necessary Permission Level a user MUST POSSES to User Classes -> RegularUser, AdminUser CLASS,
        to define specific permission levels for different types of users).

SYSTEM SHOULD HAVE
* abstract User Class -> String username (represents users in the messaging system)
* RegularUser & AdminUser CLASS (od gore) should have a DEFAULT permission level, while AdminUser should explicitly define the admin
permission level using the @UserPermission Annotation

METHODS
sendMessage -> prints which user sent a message if the user is admin, and if it is a regular user then it should print a message
                that the user is RESTRICTED. (Should apply the already created custom annotations to it)

MAIN METHOD -> INSIDE MessageSystem CLASS
Demonstrate the usage of the sendMessage method by creating instances of users with different permission levels
PRINT RESULTS TO SHOWCASE HOW THE IMPLEMENTED ANNOTATIONS ENFORCE/ALLOW MESSAGE SENDING BASED ON SPECIFIC PERMISSION LEVELS
 */

