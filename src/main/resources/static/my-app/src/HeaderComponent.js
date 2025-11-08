import React from 'react'

const HeaderComponent = () => {
    return (
        <div>
            <header>
                <nav className = "navbar navbar-expand-md navbar-dark bg-dark">
                    <div>
                        Goto <a href = "https://www.imdb.com" className = "navbar-brand">
                            ImdbMovie Actual Website 
                        </a>
                    </div>

                </nav>
            </header>
        </div>
    )
}

export default HeaderComponent
