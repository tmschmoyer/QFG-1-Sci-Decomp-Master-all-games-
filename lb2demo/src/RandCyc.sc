;;; Sierra Script 1.0 - (do not remove this comment)
;;;;
;;;;	RANDCYC.SC
;;;;
;;;;	(c) Sierra On-Line, Inc, 1990
;;;;
;;;;	Written:
;;;;		Doug Oldfield
;;;;		July 25, 1990
;;;;
;;;;
;;;;	Cycles cels randomly & constantly
;;;;
;;;;	Classes:
;;;;	  RandCycle


(script# RANDCYC)
(include game.sh)
(use Main)
(use Motion)


(class RandCycle kindof Cycle
	(properties
		count		-1
	)

	(method (init obj theTime whoCares)
		(super init: obj)
		(if (>= argc 2)			
			(= count theTime)
			(if (>= argc 3)		
				(= caller whoCares)
			)
		else 
			(= count -1)
		)
	)

	(method (doit)
		(++ cycleCnt)
		(if (> cycleCnt (client cycleSpeed?))
			(if count
				(if (> count 0) (-- count))
				(client cel: (self nextCel:))
				(= cycleCnt 0)
			else
				(self cycleDone:)
			)
		)
	)

	(method (nextCel &tmp newCel)
		(return
			(if (!= (NumCels client) 1)
				(while (== (= newCel (Random 0 (client lastCel?))) (client cel?)))
				newCel
			)
		)
	)

	(method (cycleDone)
		(= completed TRUE)
		
		;If we have a caller which needs cue:ing, set the flag for a delayed cue:.
		;Otherwise, just cue: ourselves to complete the motion.
		(if caller
			(= doMotionCue TRUE)
		else
			(self motionCue:)
		)
	)
)