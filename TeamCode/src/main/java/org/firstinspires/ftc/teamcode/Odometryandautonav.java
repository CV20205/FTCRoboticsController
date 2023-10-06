package org.firstinspires.ftc.teamcode;

public class Odometryandautonav {


    public int flocx = (1);
    public int flocy = (1);
    public int slocx = (1);
    public int slocy = (1);


        int meta = (flocy - slocy);
        int steps = 14;
        int zeta = (flocx - slocx);
        int clocy = ((zeta * steps) + slocx);
        int clocx = ((meta * steps) + slocy);
        var dsn1 = Math.sqrt(((flocx * flocx) - (slocx * slocx)) + (flocy * flocy) - (slocy * slocy));


                var n1x = (flocx-clocx);
                var n1y = (flocy - clocy);

                var n1yp = (flocy - clocy);
                var n1xp = (flocx - clocx);

                function RouteAlignN1() {
                    for (i = clocx; i < n1x; i++)
                    for (i = clocy; i < n1y; i++)
                    for (i = clocx; i > n1x; i--)
                    for (i = clocy; i > n1y; i--)
                    return run; RouteAlignN1();
                }

                function RouteAlignN2() {
                    for (i = clocx; i < n2x; i++)
                    for (i = clocy; i < n2y; i++)
                    for (i = clocx; i > n2x; i--)
                    for (i = clocy; i > n2y; i--)
                    return {clocx and clocy}
                }

                double DS = (96 * 3.14) * steps  // equation for distance traveled in mm
                double V = DS/t  // rotation based speed calcs
                double VC =   // current velocity of the robot

            function adjustspeed() {  // alternative method to systems
                    for(i = VC; i < VC; i++)  // does not return trajectory
                    for(i = VC; i > VC; i--)
                        console.print(VC) }
    }
            var clocx =   // x coordinate of current position
            var clocy =   // y coordinate of current position
            var flocx =   // x coordinate of final point
            var flocy =   // y coordinate of final point
            var blocx =   // x coordinate of second point
            var blocy =   // y coordinate of second point
            var N1x = (flocx - clocx)
            var N1x = (flocy - clocy)
            var N2x = (flocx - blocx)
            var N2x = (flocy - blocy)
            var N1 = (N1x - N1y)
            var N2 = (N2x - N2y)
            var Vconstant = Tx\Ty
            var r = 96
            const N1yP = (flocy - clocy)
            const N1xP = (flocx - clocx)
            const N2xP = (flocx - blocx)
            const N2xP = (floxy - blocy)

                var steps = 4
                var zet = (flocx - slocx)
                var met = (flocy - slocy)

                var clocx = ((zet * steps) + slocx)
                var clocy = ((met * steps) + slocy)

                var zet = (flocx - slocx)
