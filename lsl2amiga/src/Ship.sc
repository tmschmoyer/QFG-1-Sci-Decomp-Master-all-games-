;;; Sierra Script 1.0 - (do not remove this comment)
(script# SHIP)
(include game.sh)
(use Main)
(use Intrface)
(use Game)

(public
	rm300 0
)

(instance rm300 of Region
	(method (init)
		(super init:)
	)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== gameState rgLIFEBOATS)
				(not rgSeconds)
				(!= curRoomNum 38)
				(!= curRoomNum 31)
				(!= curRoomNum 131)
				(!= curRoomNum 138)
				(> roomSeconds 5)
				(== currentStatus egoNORMAL)
			)
			(= currentStatus egoDYING)
			(= gameState NULL)
			(Print SHIP 0)
			(Print SHIP 1)
			(Print SHIP 2)
		)
	)
	
	(method (handleEvent event)
		(if (or (!= (event type?) saidEvent) (event claimed?))
			(return)
		)
		(cond 
			((and (ego has: iFruit) (Said 'eat,apply/basket'))
				(Print SHIP 3)
				(ego put: iFruit -1)
				(theGame changeScore: -2)
			)
			((and (ego has: iSpinachDip) (Said 'eat,apply/bread'))
				(Print SHIP 4)
				(ego put: iSpinachDip -1)
				(theGame changeScore: -5)
			)
			((and (ego has: iWig) (Said 'wear,apply,(conceal<on)/wig'))
				(NotNow)
			)
			((and (ego has: iSewingKit) (Said 'sew,fix,apply/kit'))
				(Print SHIP 5)
			)
			(
				(and
					(ego has: iSunscreen)
					(Said 'wear,caress,conceal,apply/lotion,(lotion<suntan)')
				)
				(cond 
					((!= currentEgoView 132)
						(Print SHIP 6)
						(= sunscreenState sunscreenINLIFEBOAT)
						(if (not appliedSunscreen)
							(= appliedSunscreen TRUE)
							(theGame changeScore: 1)
						)
					)
					((== sunscreenState sunscreenAFTERSWIM)
						(Print SHIP 7)
						(= sunscreenState sunscreenAPPLIED)
						(if (not appliedSunscreenAgain)
							(= appliedSunscreenAgain TRUE)
							(theGame changeScore: 3)
						)
					)
					(else
						(Print SHIP 8)
						(= sunscreenState sunscreenAPPLIED)
						(if (not appliedSunscreen)
							(= appliedSunscreen TRUE)
							(theGame changeScore: 3)
						)
					)
				)
			)
			((Said 'look>')
				(cond 
					((Said '/cup,down,cup,lagoon,fluid')
						(Print SHIP 9)
					)
					((Said '/up,overhead,cloud')
						(Print SHIP 10)
					)
					((Said '[/craft,cloud]')
						(Print SHIP 11)
					)
					((Said '/children,man,bimbo')
						(Print SHIP 12)
					)
					((Said '/carpet,carpet,deck')
						(Print SHIP 13)
						(Print SHIP 13)
						(Print SHIP 13)
					)
					((Said '/palm,bush,bush')
						(Print SHIP 14)
					)
				)
			)
		)
	)
)